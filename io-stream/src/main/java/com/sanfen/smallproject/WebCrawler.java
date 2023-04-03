package com.sanfen.smallproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 爬取网络上的姓氏和名字
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/03 9:52
 */
public class WebCrawler {

    public static void main(String[] args) throws IOException {
        /*
            百家姓: https://hanyu.baidu.com/s?wd=%E7%99%BE%E5%AE%B6%E5%A7%93&from=poem
            男性名字: http://www.haoming8.cn/baobao/10881.html
            女性名字: http://www.haoming8.cn/baobao/7641.html
         */
        String familyName = "https://hanyu.baidu.com/s?wd=%E7%99%BE%E5%AE%B6%E5%A7%93&from=poem";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        String familyNameStr = webCrawler(familyName);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);

        // 获取百家姓
        List<String> familyNameTempList = getData(familyNameStr, "(.{4})(，|。)", 1);
        List<String> familyNames = familyNameTempList.stream()
                .flatMap(f -> Arrays.stream(f.split("")))
                .collect(Collectors.toList());

        // 获取男性名字
        List<String> boyNameTempList = getData(boyNameStr, "([\\u4E00-\\u9FA5]{2})(、|。)", 1);
        List<String> boyNames = boyNameTempList.stream().distinct().collect(Collectors.toList());

        // 获取女性名字
        List<String> girlNameTempList = getData(girlNameStr, "(.. ){4}..", 0);
        List<String> girlNames = girlNameTempList.stream()
                .flatMap(name -> Arrays.stream(name.split(" ")))
                .collect(Collectors.toList());

        // 生成数据: 姓名（唯一）-性别-年龄
        List<String> names = getInfos(familyNames, boyNames, girlNames, 200, 150);
        Collections.shuffle(names);

        // 写出数据到本地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("io-stream\\names.txt"));
        for (String name : names) {
            bw.write(name);
            bw.newLine();
        }
        bw.close();
    }

    /**
     * 获取男生和女生的姓名: 张三-男-23
     * @param familyNames 姓氏集合
     * @param boyNames 男生名字集合
     * @param girlNames 女生名字集合
     * @param boyCount 需要的男生名字数量
     * @param girlCount 需要的女生名字数量
     * @return 男生和女生的姓名集合
     */
    public static List<String> getInfos(List<String> familyNames, List<String> boyNames,
                                        List<String> girlNames, int boyCount, int girlCount) {
        // 生成男生不重复的名字
        Set<String> boyNameSet = new HashSet<>();
        while (boyNameSet.size() != boyCount) {
            // 随机生成名字
            Collections.shuffle(familyNames);
            Collections.shuffle(boyNames);
            boyNameSet.add(familyNames.get(0) + boyNames.get(0));
        }
        // 生成女生不重复的名字
        Set<String> girlNameSet = new HashSet<>();
        while (girlNameSet.size() != girlCount) {
            // 随机生成名字
            Collections.shuffle(familyNames);
            Collections.shuffle(girlNames);
            girlNameSet.add(familyNames.get(0) + girlNames.get(0));
        }
        // 数据封装: 张三-男-23
        List<String> list = new ArrayList<>();
        boyNameSet.forEach(name -> {
            String joinName = name + "-男-" + (new Random().nextInt(10) + 18);
            list.add(joinName);
        });
        girlNameSet.forEach(name -> {
            String joinName = name + "-女-" + (new Random().nextInt(8) + 18);
            list.add(joinName);
        });

        return list;
    }

    /**
     * 根据正则表达式获取字符串中的数据
     *
     * @param contentStr 完整的字符串
     * @param regex      正则表达式
     * @param index      正则匹配分组
     * @return 想要的数据
     */
    private static List<String> getData(String contentStr, String regex, int index) {
        List<String> list = new ArrayList<>();
        // 正则
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contentStr);
        while (matcher.find()) {
            list.add(matcher.group(index));
        }
        return list;
    }

    /**
     * 网络上爬取数据，拼接成字符串返回
     *
     * @param net 数据URL
     * @return 爬取的数据
     */
    public static String webCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        // 创建URL对象
        URL url = new URL(net);
        // 连接网址
        URLConnection conn = url.openConnection();
        // 读取数据(字节流-->字符流)
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        isr.close();
        return sb.toString();
    }

}
