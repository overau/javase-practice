package com.sanfen.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流
 * @author HeJin
 * @version 1.0
 * @since 2023/03/28 9:43
 */
public class IoTest8 {

    public static void main(String[] args) throws IOException {
        // 1.创建对象
        FileReader reader = new FileReader("io-stream\\a.txt");
        // 2.读取数据
        int len;
        char[] chars = new char[2];
        while ((len = reader.read(chars)) != -1){
            System.out.print(new String(chars, 0, len));
        }
        // 3.关闭资源
        reader.close();
    }

}
