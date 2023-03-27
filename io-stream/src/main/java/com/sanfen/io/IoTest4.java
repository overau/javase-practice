package com.sanfen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节输入流
 * @author HeJin
 * @version 1.0
 * @since 2023/03/27 10:24
 */
public class IoTest4 {

    public static void main(String[] args) throws IOException {
        // 1.创建对象
        InputStream inputStream = new FileInputStream("io-stream\\a.txt");
        // 2.读取数据
        int read = inputStream.read();
        System.out.println((char) read);
        // 3.释放资源
        inputStream.close();
    }

}
