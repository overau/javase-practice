package com.sanfen.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 定义一个方法查找某一个文件夹，是否有以avi结尾的电影
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 12:58
 */
@Slf4j
public class FilePractice02 {

    public static void main(String[] args) {
        File[] files = checkFile("E:\\data");
        System.out.println(Arrays.toString(files));

        File[] files1 = checkFiles("E:\\data");
        System.out.println(Arrays.toString(files1));
    }

    /**
     * 判断文件夹，是否有以avi结尾的电影
     * @param path 文件夹
     * @return 是否有以avi结尾的电影
     */
    public static File[] checkFile(String path){
        File file = new File(path);
        if (!file.exists()){
            log.error("文件夹: {} 不存在", file.getAbsolutePath());
            throw new RuntimeException("文件夹不存在!");
        }
        return file.listFiles(f -> f.isFile() && f.getName().endsWith(".avi"));
    }

    static List<File> list = new ArrayList<>();

    public static File[] checkFiles(String path){
        File file = new File(path);
        if (!file.exists()){
            log.error("文件夹: {} 不存在", file.getAbsolutePath());
            throw new RuntimeException("文件夹不存在!");
        }
        File[] files = file.listFiles();
        if (files == null){
            return null;
        }
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".avi")){
                list.add(f);
            } else if (f.isDirectory()){
                checkFiles(f.getAbsolutePath());
            }
        }
        return list.toArray(new File[0]);
    }

}
