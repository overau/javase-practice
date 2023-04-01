package com.sanfen.io.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 字符打印流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 19:02
 */
public class PrintStreamTest2 {

    public static void main(String[] args) throws IOException {
        // 1.创建字符打印流对象
        PrintWriter pw = new PrintWriter(new FileWriter("io-stream\\a.txt"), true);
        // 2.写出数据
        pw.println("你好");
        pw.print(true);
        pw.printf("%s 爱上了 %s", "阿珍", "阿强");
        // 3.关闭资源
        pw.close();
    }

}
