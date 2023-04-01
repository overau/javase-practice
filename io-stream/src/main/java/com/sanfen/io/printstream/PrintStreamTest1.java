package com.sanfen.io.printstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * 字节打印流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 18:51
 */
public class PrintStreamTest1 {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        // 1.创建字节打印流对象
        PrintStream ps = new PrintStream(new FileOutputStream("io-stream\\a.txt"),
                true, "UTF-8");
        // 2.写出数据
        ps.println(97);
        ps.print(true);
        ps.println();
        ps.printf("%s 爱上了 %s", "阿珍", "阿强");
        // 3.释放资源
        ps.close();
    }

}
