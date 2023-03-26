package com.sanfen.file;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * File常见的成员方法: 判断、获取
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 10:58
 */
public class FileTest2 {

    public static void main(String[] args) {
        File file1 = new File("E:\\data\\1.html");
        System.out.println("是不是文件: " + file1.isFile());
        System.out.println("是不是文件夹: " + file1.isDirectory());
        System.out.println("文件是否存在: " + file1.exists());

        System.out.println("=======================================");
        File file2 = new File("E:\\data");
        System.out.println("是不是文件: " + file2.isFile());
        System.out.println("是不是文件夹: " + file2.isDirectory());
        System.out.println("文件夹是否存在: " + file2.exists());

        System.out.println("==================不存在的文件============");
        File file3 = new File("E:\\data\\2.txt");
        System.out.println("是不是文件: " + file3.isFile());
        System.out.println("是不是文件夹: " + file3.isDirectory());
        System.out.println("文件夹是否存在: " + file3.exists());

        System.out.println("==================获取文件信息============");
        File file4 = new File("E:\\data\\1.html");
        System.out.println("文件大小(字节): " + file4.length());
        File file5 = new File("E:\\data\\bbb");
        System.out.println("文件夹大小(字节): " + file5.length());

        System.out.println("=========================================");
        File file6 = new File("io-stream\\pom.xml");
        System.out.println("绝对路径: " + file6.getAbsolutePath());
        System.out.println("传入的路径: " + file6.getPath());
        System.out.println("文件名: " + file6.getName());
        long lastModified = file6.lastModified();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(lastModified), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = formatter.format(localDateTime);
        System.out.println("最后修改时间: " + lastModified + " === " + time);
    }

}
