package com.sanfen.practice2;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 利用反射动态的创建对象和运行方法
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 10:11
 */
public class ReflectDemo2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1.读取配置文件
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("reflect-study\\prop.properties");
        prop.load(fis);
        String classname = prop.getProperty("classname");
        String methodName = prop.getProperty("method");

        // 2.反射创建对象
        Class<?> clazz = Class.forName(classname);
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getDeclaredMethod(methodName);
        method.invoke(obj);
    }

}
