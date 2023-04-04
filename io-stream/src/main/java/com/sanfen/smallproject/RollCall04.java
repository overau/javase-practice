package com.sanfen.smallproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 随机点名器4
 * (1)被点到的学生不会再点到
 * (2)如果班级中所有的学生都点完了，需要自动的重新开启第二轮点名
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/04 20:27
 */
public class RollCall04 {

    public static void main(String[] args) throws IOException {
        // 读取文件数据
        List<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("io-stream\\names.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] strings = line.split("-");
            Student student = new Student();
            student.setName(strings[0]);
            student.setGender("女".equals(strings[1]) ? 0 : 1);
            student.setAge(Integer.parseInt(strings[2]));
            students.add(student);
        }
        br.close();

        // 被点过名的学生集合
        List<Student> calledStudents = new ArrayList<>();
        // 点名次数
        int count = 0;
        // 开启2轮点名
        for (int i = 0; i < 2; i++) {
            System.out.println("======================第 " + (i + 1) + " 轮点名==========================");
            while (students.size() > 0) {
                Collections.shuffle(students);
                Student calledStudent = students.get(0);
                System.out.println("第 " + (++count) + " 次点名: " + calledStudent.getName());
                calledStudents.add(calledStudent);
                students.remove(calledStudent);
            }
            students.addAll(calledStudents);
            calledStudents.clear();
        }
    }

}
