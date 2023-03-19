package com.sanfen;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 带权重的随机点名器
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 9:55
 */
@Slf4j
public class RollCallWithWeightTest {

    public static List<String> names;

    public static List<String> surnames;

    static {
        names = new ArrayList<>();
        try {
            names.addAll(loadNameFromFile("classpath:asserts/男性"));
            names.addAll(loadNameFromFile("classpath:asserts/女性"));
            surnames = loadNameFromFile("classpath:asserts/百家姓");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 1.TxT文件中事先准备好80个学生姓名，每个学生的名字独占一行，进行随机点名。
     * 2.每次被点到的学生，再次被点到的概率在原先的基础上降低一半。
     * 举例：
     * 80个学生，点名5次，每次都点到小A，概率变化情况如下：
     * 第一次每人概率：1.25%。
     * 第二次小A概率：0.625%。  其他学生概率：1.2579%
     * 第三次小A概率：0.3125%。  其他学生概率：1.261867%
     * 第四次小A概率：0.15625%。  其他学生概率：1.2638449%
     * 第五次小A概率：0.078125%。  其他学生概率：1.26483386%
     */

    @Test
    public void initFileStudent() throws IOException {
        File file = new File("student.txt");
        if (!file.exists()){
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        for (int i = 0; i < 80; i++) {
            Student student = new Student();
            student.setName(generateNameList());
            student.setAge(RandomUtil.randomInt(10, 40));
            String gender = RandomUtil.randomInt(2) == 0 ? "女" : "男";
            student.setGender(gender);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(JSONUtil.toJsonStr(student) + "\n", true);
        }
        log.info("学生姓名文件生成成功...");
    }

    private String generateNameList() {
        // 打乱姓名和名字集合
        Collections.shuffle(names);
        Collections.shuffle(surnames);
        return surnames.get(0) + names.get(0);
    }

    private static List<String> loadNameFromFile(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = fileReader.getReader();
        List<String> nameList = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null){
            String[] split = line.trim().split("\\s+");
            nameList.addAll(Arrays.asList(split));
        }
        return nameList;
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("classpath:student.txt");
        List<String> nameJsonList = fileReader.readLines();
        List<Student> studentList = nameJsonList.stream()
                .map(nameJson -> JSONUtil.toBean(nameJson, Student.class))
                .collect(Collectors.toList());

    }

    @Test
    public void testWeight(){
        List<Integer> weights = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6));
        Map<Integer, String> map = new HashMap<>(weights.size());
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(6, "E");
        log.info("元素权重: {}", map);

        List<Integer> weightTmp = new ArrayList<>(weights.size() + 1);
        weightTmp.add(0);
        int sum = 0;
        // [0, 1, 3, 6, 10, 16]
        for (Integer weight : weights) {
            sum += weight;
            weightTmp.add(sum);
        }
        for (int k = 0; k < 100; k++) {
            log.info("==================第 {} 次点名===============", (k + 1));
            int rand = RandomUtil.randomInt(sum);
            log.info("随机数为: {}", rand);
            int index = 0;
            for (int i = weightTmp.size() - 1; i >= 0 ; i--) {
                if (rand >= weightTmp.get(i)){
                    index = i;
                    break;
                }
            }
            log.info("点到的学生是: {}", map.get(weights.get(index)));
        }
    }

}
