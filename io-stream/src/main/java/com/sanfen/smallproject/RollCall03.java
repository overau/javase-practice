package com.sanfen.smallproject;

import cn.hutool.core.io.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 随机点名器3
 * 随机点名，第3次一定是张三同学
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/03 14:32
 */
public class RollCall03 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("io-stream\\count.txt"));
        int count = Integer.parseInt(reader.readLine());
        reader.close();
        if (++count == 3) {
            System.out.println("第 " + count + " 次点名: 张三");
            // 记录次数到文件
            FileUtil.writeUtf8String(String.valueOf(count), new File("io-stream\\count.txt"));
            return;
        }
        // 定义存放名字的集合
        List<Student> studentList = new ArrayList<>();
        // 读取文件数据
        BufferedReader br = new BufferedReader(new FileReader("io-stream\\names.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] lineStr = line.split("-");
            Student student = new Student();
            student.setName(lineStr[0]);
            student.setGender("女".equals(lineStr[1]) ? 0 : 1);
            student.setAge(Integer.valueOf(lineStr[2]));
            studentList.add(student);
        }
        // 打乱集合
        Collections.shuffle(studentList);
        System.out.println("第 " + count + " 次点名: " + studentList.get(0).getName());
        // 记录次数到文件
        FileUtil.writeUtf8String(String.valueOf(count), new File("io-stream\\count.txt"));
    }

}
