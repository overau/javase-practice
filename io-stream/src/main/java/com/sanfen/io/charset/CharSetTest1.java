package com.sanfen.io.charset;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/27 13:31
 */
public class CharSetTest1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("io-stream\\a.txt");
        int b;
        while ((b = fis.read()) != -1){
            System.out.print((char) b);
        }
        fis.close();
    }

}
