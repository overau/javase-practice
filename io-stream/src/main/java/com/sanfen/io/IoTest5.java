package com.sanfen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *  字节输入流循环读取
 * @author HeJin
 * @version 1.0
 * @since 2023/03/27 10:40
 */
public class IoTest5 {

    public static void main(String[] args) throws IOException {
        // 1.创建对象
        InputStream inputStream = new FileInputStream("io-stream\\a.txt");
        // 2.循环读取
        int b;
        while ((b = inputStream.read()) != -1){
            System.out.print((char) b);
        }
        // 3.关闭资源
        inputStream.close();
    }

}
