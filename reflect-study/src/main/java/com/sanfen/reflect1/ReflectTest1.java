package com.sanfen.reflect1;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/07 20:35
 */
public class ReflectTest1 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1.第一种方式：最常用
        Class<?> clazz1 = Class.forName("com.sanfen.reflect1.Student");
        System.out.println(clazz1);

        // 2.第二种方式：当做参数传递
        Class<Student> clazz2 = Student.class;
        System.out.println(clazz2);

        // 3.第三种方式：已经有了这个类的对象
        Student student = new Student();
        Class<? extends Student> clazz3 = student.getClass();
        System.out.println(clazz3);

        System.out.println("===================================");
        System.out.println("clazz1 == clazz2 ? " + (clazz1 == clazz2));
        System.out.println("clazz2 == clazz3 ? " + (clazz2 == clazz3));
    }

}
