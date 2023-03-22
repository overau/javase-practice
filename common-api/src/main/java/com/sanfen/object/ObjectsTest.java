package com.sanfen.object;

import java.util.Objects;

/**
 * Objects
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 15:05
 */
public class ObjectsTest {

    public static void main(String[] args) {
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("张三", 23);
        boolean equals = Objects.equals(s1, s2);
        System.out.println(equals);
        Student s3 = null;
        System.out.println(Objects.isNull(s3));
        System.out.println(Objects.nonNull(s3));
    }

}
