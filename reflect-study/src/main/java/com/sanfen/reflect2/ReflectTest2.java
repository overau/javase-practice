package com.sanfen.reflect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * 反射获取构造方法
 * @author HeJin
 * @version 1.0
 * @since 2023/04/07 20:51
 */
public class ReflectTest2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.sanfen.reflect2.Student");
        // 获取构造方法
        Constructor<?>[] constructors1 = clazz.getConstructors();
        for (Constructor<?> constructor : constructors1) {
            System.out.println(constructor);
        }

        System.out.println("===============================================");
        Constructor<?>[] constructors2 = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors2) {
            System.out.println(constructor);
        }

        System.out.println("===============================================");
        Constructor<?> constructor3 = clazz.getDeclaredConstructor(String.class, Integer.class);
        System.out.println("全参构造方法: " + constructor3);
        Constructor<?> constructor4 = clazz.getDeclaredConstructor(String.class);
        System.out.println("String参数构造方法: " + constructor4);
        Constructor<?> constructor5 = clazz.getDeclaredConstructor(Integer.class);
        System.out.println("Integer参数全参构造方法: " + constructor5);
        Constructor<?> constructor6 = clazz.getDeclaredConstructor();
        System.out.println("无参构造方法: " + constructor6);

        System.out.println("===============================================");
        int modifiers = constructor3.getModifiers();
        System.out.println(modifiers);
        Parameter[] parameters = constructor3.getParameters();
        System.out.println(Arrays.toString(parameters));

        System.out.println("===============================================");
        // 临时取消权限校验
        constructor3.setAccessible(true);
        Student student = (Student)constructor3.newInstance("张三", 23);
        System.out.println(student);
    }

}
