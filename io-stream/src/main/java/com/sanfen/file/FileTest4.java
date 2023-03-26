package com.sanfen.file;

import java.io.File;

/**
 * File常见的成员方法: 获取并遍历
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 12:01
 */
public class FileTest4 {

    public static void main(String[] args) {
        File f = new File("E:\\data");
        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }

}
