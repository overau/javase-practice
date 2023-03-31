package com.sanfen.io.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * 拷贝一个文件夹，考虑子文件夹
 * @author HeJin
 * @version 1.0
 * @since 2023/03/31 10:40
 */
public class CopyFolder {

    public static void main(String[] args) throws IOException {
        copyFolder("E:\\data", "E:\\666");
    }

    public static void copyFolder(String srcDir, String targetDir) throws IOException {
        // 1.创建目标文件夹: 目标文件夹 + 原始文件夹
        File targetFile = new File(targetDir, new File(srcDir).getName());
        if (!targetFile.exists()){
            if (!targetFile.mkdirs()){
                throw new RuntimeException("创建目标文件夹失败!");
            }
        }
        // 2.遍历原始文件夹
        File srcFile = new File(srcDir);
        if (!srcFile.exists()){
            throw new RuntimeException("原始文件夹不存在!");
        }
        File[] files = srcFile.listFiles();
        if (Objects.isNull(files)){
            return;
        }
        for (File file : files) {
            if (file.isFile()){
                // 文件，则拷贝到目标文件夹
                copyFile(file, targetFile);
            } else {
                // 目录，递归处理诸葛目录
                copyFolder(file.getPath(), targetFile.getAbsolutePath());
            }
        }
    }

    public static void copyFile(File srcFile, File destDir) throws IOException {
        if (!srcFile.isFile()){
            throw new RuntimeException("源文件不合法: " + srcFile.getPath());
        }
        if(!destDir.isDirectory()){
            throw new RuntimeException("目标文件夹不合法: " + destDir.getPath());
        }
        // 边读边写
        FileInputStream inputStream = new FileInputStream(srcFile);
        FileOutputStream outputStream = new FileOutputStream(new File(destDir, srcFile.getName()));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1){
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        inputStream.close();
    }

}
