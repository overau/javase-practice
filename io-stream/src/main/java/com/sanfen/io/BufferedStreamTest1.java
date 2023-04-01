package com.sanfen.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符缓冲输入流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 12:02
 */
public class BufferedStreamTest1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("io-stream\\a.txt"));

        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
    }

}
