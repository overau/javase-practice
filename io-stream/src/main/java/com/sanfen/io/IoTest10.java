package com.sanfen.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * properties属性文件
 * @author HeJin
 * @version 1.0
 * @since 2023/04/07 13:46
 */
public class IoTest10 {

    public static void main(String[] args) throws IOException {
        // 1.创建集合对象
        Properties prop = new Properties();
        // 2.添加数据
        prop.put("name", "张三");
        prop.put("age", "26");
        // 3.打印集合
        System.out.println(prop);
        // 4.io流相关
        FileOutputStream fos = new FileOutputStream("io-stream\\a.properties");
        prop.store(fos, "test");
        fos.close();
    }

}
