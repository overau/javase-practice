package com.sanfen.io.convertstream;

import cn.hutool.core.io.FileUtil;

import java.io.*;

/**
 * 转换流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 15:22
 */
public class ConvertStreamTest3 {

    public static void main(String[] args) throws IOException {
        // 将本地文件中的GBK文件，转成UTF-8
        // 使用GBK编码读取文件，使用UTF-8编码写出文件
        File srcFile = new File("io-stream\\gbkfile.txt");
        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFile), "GBK");
        File tempFile = File.createTempFile("copy-", null);
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8");

        int b;
        while ((b = isr.read()) != -1){
            osw.write(b);
        }
        osw.close();
        isr.close();

        // 覆盖源文件
        FileUtil.copy(tempFile, srcFile, true);
    }

}
