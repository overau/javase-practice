package com.sanfen.io.objectstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 17:33
 */
public class ObjectStreamTest1 {

    public static void main(String[] args) throws IOException {
        // 1.创建对象
        Student student = new Student("张三", 25);
        // 2.创建对象输出李玉
        FileOutputStream fos = new FileOutputStream("io-stream\\a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // 3.写出对象
        oos.writeObject(student);
        // 4.关闭资源
        oos.close();
    }

}
