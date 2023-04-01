package com.sanfen.io.convertstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 转换流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 15:22
 */
public class ConvertStreamTest2 {

    public static void main(String[] args) throws IOException {
        // 利用转换流按照指定编码写出数据到文件
        FileOutputStream fileOutputStream = new FileOutputStream("io-stream\\gbk1.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream, "GBK");
        osw.write("利用转换流按照指定编码写出数据到文件");
        osw.close();
    }

}
