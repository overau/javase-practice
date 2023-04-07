package com.sanfen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * 读取properties属性文件
 * @author HeJin
 * @version 1.0
 * @since 2023/04/07 13:46
 */
public class IoTest11 {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("io-stream\\a.properties");
        prop.load(fis);

        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

}
