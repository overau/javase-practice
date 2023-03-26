package com.sanfen.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 换行写和续写
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 15:26
 */
public class IoTest3 {

    public static void main(String[] args) throws IOException {
        // 1.创建对象
        OutputStream outputStream = new FileOutputStream("io-stream\\a.txt");
        // 2.写出数据
        String str1 = "abc";
        byte[] bytes1 = str1.getBytes();
        outputStream.write(bytes1);

        outputStream.write("\r\n".getBytes());

        String str2 = "666";
        byte[] bytes2 = str2.getBytes();
        outputStream.write(bytes2);
        // 3.关闭资源
        outputStream.close();
    }

}
