package com.sanfen.reflect3;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 反射获取成员变量
 * @author HeJin
 * @version 1.0
 * @since 2023/04/07 21:28
 */
public class ReflectTest3 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.sanfen.reflect3.Student");
        // 获取public的成员变量
        System.out.println("==================获取public的成员变量===============");
        Field[] fields1 = clazz.getFields();
        System.out.println(Arrays.toString(fields1));

        // 获取所有成员变量
        System.out.println("==================获取所有成员变量===================");
        Field[] fields2 = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(fields2));

        // 获取单个的成员变量
        System.out.println("==================获取单个的成员变量=================");
        Field name = clazz.getDeclaredField("name");
        int modifiers = name.getModifiers();
        System.out.println(modifiers);
        System.out.println(name.getName());
        System.out.println(name.getType());

        // 获取和修改成员变量的值
        System.out.println("==================获取和修改成员变量的值===================");
        Student student = new Student("张三", 26, "男");
        name.setAccessible(true);
        String nameValue = (String) name.get(student);
        System.out.println(nameValue);
        // 修改对象的值
        name.set(student, "李四");
        System.out.println(student);
    }

}
