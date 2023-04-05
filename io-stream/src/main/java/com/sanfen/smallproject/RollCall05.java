package com.sanfen.smallproject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 带权重的随机算法
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/05 12:27
 */
public class RollCall05 {

    public static void main(String[] args) throws IOException {
        // 1.读取文件数据到内存
        List<Student> studentList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("io-stream\\names.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] strings = line.split("-");
            Student student = new Student();
            student.setName(strings[0]);
            student.setGender("女".equals(strings[1]) ? 0 : 1);
            student.setAge(Integer.parseInt(strings[2]));
            student.setWeight(Double.parseDouble(strings[3]));
            studentList.add(student);
        }
        br.close();

        // 2.计算权重的总和
        double weight = studentList.stream()
                .map(Student::getWeight)
                .reduce(0.0, Double::sum);

        // 3.计算权重占比: [0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1]
        List<Double> weightPerList = studentList.stream()
                .map(student -> student.getWeight() / weight)
                .collect(Collectors.toList());

        // 4.计算每个学生的权重占比范围
        for (int i = 1; i < weightPerList.size(); i++) {
            weightPerList.set(i, weightPerList.get(i) + weightPerList.get(i - 1));
        }

        // 5.随机抽取
        // 获取一个0.0~1.0之前的随机数
        double number = Math.random();
        //  (-(insertion point) - 1)
        int tempIndex = Arrays.binarySearch(weightPerList.toArray(), number);
        int index = -(tempIndex + 1);
        Student student = studentList.get(index);
        System.out.println(student.getName());

        // 6.修改抽取到的学生的权重
        student.setWeight(student.getWeight() / 2);

        // 7.集合中的数据再次写到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("io-stream\\names.txt"));
        for (Student stu : studentList) {
            bw.write(stu.toString());
            bw.newLine();
        }
        bw.close();
    }

}
