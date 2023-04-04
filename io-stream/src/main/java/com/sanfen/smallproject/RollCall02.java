package com.sanfen.smallproject;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 随机点名器2
 * 70%的概率随机到男生，30%的概率随机到女生
 * 总共随机100万次，统计结果
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/03 14:05
 */
@Slf4j
public class RollCall02 {

    static List<Student> boyStudentList;

    static List<Student> girlStudentList;

    static {
        // 存放学生对象的集合
        boyStudentList = new ArrayList<>();
        girlStudentList = new ArrayList<>();
        // 读取文件数据
        try {
            BufferedReader br = new BufferedReader(new FileReader("io-stream\\names.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineStr = line.split("-");
                Student student = new Student();
                student.setName(lineStr[0]);
                student.setGender("女".equals(lineStr[1]) ? 0 : 1);
                student.setAge(Integer.valueOf(lineStr[2]));
                if (student.getGender() == 1){
                    boyStudentList.add(student);
                } else {
                    girlStudentList.add(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        // 男生:女生 = 7:3
        int[] randArr = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0};
        // 男生被随机到的次数
        int boyCount = 0;
        // 女生被随机到的次数
        int girlCount = 0;

        log.info("100万次随机点名开始...");

        for (int i = 0; i < 1000000; i++) {
            int index = new Random().nextInt(randArr.length);
            if (randArr[index] == 1){
                // 随机到男生
                boyCount++;
                Collections.shuffle(boyStudentList);
            } else {
                // 随机到女生
                girlCount++;
                Collections.shuffle(girlStudentList);
            }
        }
        log.info("100万次随机点名结束~~~");

        log.info("100万次随机点名，男生被随机到的次数: {}", boyCount);
        log.info("100万次随机点名，女生被随机到的次数: {}", girlCount);
    }

}
