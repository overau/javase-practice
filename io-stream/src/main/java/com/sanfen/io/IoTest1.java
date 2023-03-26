package com.sanfen.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * IO流: 存储䄦读取数据的解决方案
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 14:13
 */
public class IoTest1 {

    public static void main(String[] args) throws IOException {
        // 1.创建对象
        OutputStream outputStream = new FileOutputStream("io-stream\\a.txt");
        // 2.写出数据
        outputStream.write(97);
        // 3.关闭资源
        outputStream.close();
    }

}
