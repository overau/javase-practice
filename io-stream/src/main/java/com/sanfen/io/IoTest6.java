package com.sanfen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * public int read(byte b[])
 * @author HeJin
 * @version 1.0
 * @since 2023/03/27 12:48
 */
public class IoTest6 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("io-stream\\a.txt");
        byte[] bytes = new byte[2];
        int len = fis.read(bytes);
        System.out.println(len);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes, 0, len));

        fis.close();
    }

}
