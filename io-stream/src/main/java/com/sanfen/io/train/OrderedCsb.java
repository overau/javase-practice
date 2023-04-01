package com.sanfen.io.train;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 把《出师表》的文章顺序进行恢复到一个新文件中
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 12:49
 */
public class OrderedCsb {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("io-stream\\csb.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("io-stream\\csb-order.txt"));

        List<String> strings = new ArrayList<>();

        // 读取文本中的每一行数组到strings
        String line;
        while ((line = br.readLine()) != null){
            strings.add(line);
        }
        // strings排序
        List<String> sortedStrings = strings.stream()
                .sorted(Comparator.comparingInt(o -> Integer.parseInt(o.split("\\.")[0])))
                .collect(Collectors.toList());
        // 写出排序文本到文件
        for (String str : sortedStrings) {
            bw.write(str);
            bw.newLine();
        }

        bw.close();
        br.close();
    }

}
