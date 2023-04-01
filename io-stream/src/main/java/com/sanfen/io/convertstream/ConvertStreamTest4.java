package com.sanfen.io.convertstream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 转换流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 15:57
 */
public class ConvertStreamTest4 {

    public static void main(String[] args) throws IOException {
        // 利用字节流读取文件中的数据，每次读取一行，而且不能出现乱码
        // 1.字节输入流
        FileInputStream fileInputStream = new FileInputStream("io-stream\\gbkfile.txt");
        // 2.输入包装流
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        // 字符缓存输入流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
    }

}
