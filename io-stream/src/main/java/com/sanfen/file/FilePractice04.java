package com.sanfen.file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计文件夹中每种文件的个数并打印(考虑子文件夹)
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 13:37
 */
public class FilePractice04 {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        getFileCount("E:\\pictures");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void getFileCount(String path){
        File f = new File(path);
        if (!f.exists()){
            throw new RuntimeException("文件夹 " + f.getAbsolutePath() + " 不存在!");
        }
        File[] files = f.listFiles();
        if (files == null){
            return;
        }
        for (File file : files) {
            if (file.isFile()){
                String fileName = file.getName();
                String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
                if (map.containsKey(fileExtension)){
                    Integer value = map.get(fileExtension);
                    map.put(fileExtension, ++value);
                } else {
                    map.put(fileExtension, 1);
                }
            } else {
                getFileCount(file.getAbsolutePath());
            }
        }
    }

}
