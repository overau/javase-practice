package com.sanfen.io.practice;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 修改文件中的数据
 * 文件中的数据: 2-1-9-4-7-8
 * 修改后: 1-2-4-7-8-9
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 10:04
 */
public class AlterFileData {

    public static void main(String[] args) throws IOException {
        // 1.读取数据
        FileReader reader = new FileReader("io-stream\\a.txt");
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1){
            sb.append((char) ch);
        }
        reader.close();
        System.out.println(sb);

        // 2.排序
        String[] arrStr = sb.toString().split("-");
        String orderedStr = Arrays.stream(arrStr)
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining("-"));
        System.out.println(orderedStr);

        // 3.写出到文件
        FileWriter writer = new FileWriter("io-stream\\a.txt");
        writer.write(orderedStr);
        writer.close();
    }

}
