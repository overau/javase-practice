package com.sanfen.io.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件拷贝改写
 * @author HeJin
 * @version 1.0
 * @since 2023/03/27 10:54
 */
public class FileCopy2 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        // 1.创建对象
        FileInputStream fis = new FileInputStream("io-stream\\a.txt");
        FileOutputStream fos = new FileOutputStream("io-stream\\b.txt");
        // 2.拷贝
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes, 0, len);
        }
        // 3.关闭资源
        fis.close();
        fos.close();
        long end = System.currentTimeMillis();
        System.out.println("拷贝文件耗时: " + (end - start));
    }

}
