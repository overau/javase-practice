package com.sanfen.practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 保存任意对象数据到文件
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 9:26
 */
public class ReflectDemo1 {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        Student s = new Student("小A", 23, "女", 167.5, "睡觉");
        Teacher t = new Teacher("播妞", 10000);

        saveObject(s);
    }

    /**
     * 把对象里面的成员变量名和值保存到本地
     */
    private static void saveObject(Object obj) throws IllegalAccessException, IOException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Properties prop = new Properties();
        for (Field field : fields) {
            field.setAccessible(true);
            prop.put(field.getName(), field.get(obj).toString());
        }
        // properties保存到本地文件
        FileOutputStream fos = new FileOutputStream("reflect-study\\name.properties");
        prop.store(new OutputStreamWriter(fos, StandardCharsets.UTF_8), null);
        fos.close();
    }

}
