package com.sanfen.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter字符输出流
 * @author HeJin
 * @version 1.0
 * @since 2023/03/30 21:47
 */
public class IoTest9 {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("io-stream\\a.txt", true);
        writer.write("今天");
        writer.close();
    }

}
