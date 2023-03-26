package com.sanfen.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 15:17
 */
public class IoTest2 {

    public static void main(String[] args) throws IOException {
        /*
         void write(int b)
         void write(byte b[])
         void write(byte b[], int off, int len)
        */
        // 1.创建对象
        OutputStream outputStream = new FileOutputStream("io-stream\\a.txt");
        // 2.写出数据
        outputStream.write(97);
        outputStream.write(98);

        byte[] bytes = {99, 100, 101, 102};
        outputStream.write(bytes);

        outputStream.write(bytes, 2, 2);
        // 3.释放资源
        outputStream.close();
    }

}