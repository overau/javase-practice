package com.sanfen.io.objectstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 17:44
 */
public class ObjectStreamTest2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("io-stream\\a.txt"));
        Object object = ois.readObject();
        System.out.println(object);
        Student student = (Student) object;
        System.out.println(student);
    }

}
