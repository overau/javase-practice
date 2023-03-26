package com.sanfen.file;

import java.io.File;

/**
 * File类
 * @author HeJin
 * @version 1.0
 * @since 2023/03/25 15:46
 */
public class FileTest1 {

    public static void main(String[] args) {
        String str = "E:\\data\\1.html";
        // 1.根据字符串路径构建File对象
        File file1 = new File(str);
        System.out.println(file1);
        // 2.根据父路径构建File对象
        String parent = "E:\\data";
        String child = "1.html";
        File file2 = new File(parent, child);
        System.out.println(file2);
        // 3.File表示的路径和子级路径
        File parent2 = new File("E:\\data");
        String child2 = "1.html";
        File file3 = new File(parent2, child2);
        System.out.println(file3);
    }

}
