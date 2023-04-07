package com.sanfen.reflect4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 反射获取成员方法
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/07 21:45
 */
public class ReflectTest4 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.sanfen.reflect4.Student");
        System.out.println("================获取public方法===========");
        Method[] methods1 = clazz.getMethods();
        Arrays.stream(methods1).forEach(System.out::println);

        System.out.println("================获取所有方法============== ");
        Method[] methods2 = clazz.getDeclaredMethods();
        Arrays.stream(methods2).forEach(System.out::println);

        System.out.println("================获取单个方法============== ");
        Method method1 = clazz.getMethod("sleep");
        Method method2 = clazz.getDeclaredMethod("eat", String.class);
        System.out.println(method1);
        System.out.println(method2);

        System.out.println("================获取方法信息============== ");
        System.out.println("修饰符: " + method2.getModifiers());
        System.out.println("参数: " + Arrays.toString(method2.getParameters()));
        System.out.println("返回值: " + method2.getReturnType());

        System.out.println("================调用方法============== ");
        method2.setAccessible(true);
        method2.invoke(new Student("张三", 25), "苹果");
    }

}
