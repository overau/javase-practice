package com.sanfen.io.convertstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 15:22
 */
public class ConvertStreamTest1 {

    public static void main(String[] args) throws IOException {
        // 利用转换流按照指定编码读取
        FileInputStream fileInputStream = new FileInputStream("io-stream\\gbkfile.txt");
        InputStreamReader isr = new InputStreamReader(fileInputStream, "GBK");
        int ch;
        while ((ch = isr.read()) != -1){
            System.out.print((char) ch);
        }
        isr.close();

        // JDK11 替代方案FileReader
    }

}
