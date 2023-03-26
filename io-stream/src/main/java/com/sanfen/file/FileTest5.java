package com.sanfen.file;

import java.io.File;
import java.util.Arrays;

/**
 * File常见的成员方法: 所有获取并遍历的方法
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 12:01
 */
public class FileTest5 {

    public static void main(String[] args) {
        File f = new File("E:\\data");

        // 1.获取系统中所有的盘符: File.listRoots()
        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));

        // 2.获取当前路径下所有的内容(名称): list()
        System.out.println("======================================");
        String[] strings = f.list();
        System.out.println(Arrays.toString(strings));

        // 3.利用过滤器获取当前路径下所有的内容(名称): list(FilenameFilter filter)
        System.out.println("======================================");
        String[] strings1 = f.list((dir, name) -> {
            File src = new File(dir, name);
            return src.isFile() && name.endsWith(".avi");
        });
        System.out.println(Arrays.toString(strings1));

        // 4.获取当前路径下所有的文件对象: listFiles()
        System.out.println("======================================");
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".avi")){
                System.out.println(file);
            }
        }

        // 4.根据过滤器获取当前路径下所有的文件对象:
        // listFiles(FileFilter filter)
        // listFiles(FilenameFilter filter)
        System.out.println("======================================");
        File[] listFiles = f.listFiles(file -> file.isFile() && file.getName().endsWith(".mp4"));
        System.out.println(Arrays.toString(listFiles));

        System.out.println("======================================");
        File[] listFiles1 = f.listFiles((dir, name) -> {
            File src = new File(dir, name);
            return src.isFile() && name.endsWith(".mp4");
        });
        System.out.println(Arrays.toString(listFiles1));
    }

}
