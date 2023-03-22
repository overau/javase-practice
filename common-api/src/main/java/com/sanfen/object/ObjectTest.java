package com.sanfen.object;

/**
 * Object类
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 13:43
 */
public class ObjectTest {

    public static void main(String[] args) {
        Object obj = new Object();
        String str = obj.toString();
        System.out.println(str);

        Student student1 = new Student("张三", 25);
        Student student2 = new Student("张三", 25);
        System.out.println(student1.equals(student2));

        String s = "abc";
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(s.equals(sb));
        System.out.println(sb.equals(s));
    }

}
