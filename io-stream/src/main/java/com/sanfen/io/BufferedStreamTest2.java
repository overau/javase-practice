package com.sanfen.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符缓冲输出流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 12:02
 */
public class BufferedStreamTest2 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw= new BufferedWriter(new FileWriter("io-stream\\c.txt"));

        bw.write("你好啊");
        bw.newLine();

        bw.close();
    }

}
