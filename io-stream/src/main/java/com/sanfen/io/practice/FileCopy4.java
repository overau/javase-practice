package com.sanfen.io.practice;

import java.io.*;

/**
 * 字节缓冲流拷贝文件
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 10:55
 */
public class FileCopy4 {

    public static void main(String[] args) throws IOException {
        // 1.创建对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("io-stream\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("io-stream\\copy.txt"));

        // 2.读取
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }

        // 3.关闭资源
        bos.close();
        bis.close();
    }

}
