package com.sanfen.io.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密和解密文件
 * @author HeJin
 * @version 1.0
 * @since 2023/03/31 19:04
 */
public class FileEncrypt {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("io-stream\\ency.jpg");
        FileOutputStream fos = new FileOutputStream("io-stream\\1.jpg");

        int b;
        while ((b = fis.read()) != -1){
            fos.write(b ^ 114514);
        }

        fos.close();
        fis.close();
    }

}
