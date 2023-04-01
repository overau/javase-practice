package com.sanfen.io.objectstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 将多个对象序列化到文件中，但是由于对象的个数不确定，
 * 反序列化该如何读取呢
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 18:21
 */
public class ObjectStreamTest3 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("张三", 30);
        Student s2 = new Student("李四", 25);
        Student s3 = new Student("王五", 25);

        // 序列化多个对象，把对象装进集合，在序列化集合
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        // 序列化对象到文件
        Path path = Paths.get("io-stream\\a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
        oos.writeObject(list);
        oos.close();

        // 读取序列化文件到对象
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
        List<Student> studentList = (List<Student>) ois.readObject();
        System.out.println(studentList);
        ois.close();
    }
}
