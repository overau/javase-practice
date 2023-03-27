package com.sanfen.io.practice;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件拷贝改写
 * @author HeJin
 * @version 1.0
 * @since 2023/03/27 10:54
 */
@Slf4j
public class FileCopy2 {

    public static void main(String[] args) throws IOException {
        String srcFile = "io-stream\\c.txt";
        String destFile = "io-stream\\b.txt";
        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            long start = System.currentTimeMillis();
            // 2.拷贝
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1){
                fos.write(bytes, 0, len);
            }
            long end = System.currentTimeMillis();
            System.out.println("拷贝文件耗时: " + (end - start));
        } catch (IOException e) {
            log.error("拷贝文件出错! src: {} =========> dest: {}", srcFile, destFile);
            throw new RuntimeException(e);
        }
    }

}
