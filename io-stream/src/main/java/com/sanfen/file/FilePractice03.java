package com.sanfen.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * 删除多级文件夹
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 13:21
 */
@Slf4j
public class FilePractice03 {

    public static void main(String[] args) {
        deleteFile("E:\\data");
    }

    public static void deleteFile(String path){
        File file = new File(path);
        if (!file.exists()){
            throw new RuntimeException("文件夹 "+ file.getAbsolutePath() + " 不存在");
        }
        File[] files = file.listFiles();
        if (files == null){
            return;
        }
        for (File f : files) {
            if (f.isFile()){
                boolean isDelete = f.delete();
                if (isDelete){
                    log.info("删除文件: {}", f.getAbsolutePath());
                } else {
                    log.error("文件 {} 删除失败!", f.getAbsolutePath());
                    return;
                }
            } else {
                // 递归删除子文件夹
                deleteFile(f.getAbsolutePath());
            }
        }

        if (file.delete()){
            log.info("删除文件夹: {} ", file.getAbsolutePath());
        } else {
            log.error("文件夹 {} 删除失败!", file.getAbsolutePath());
        }
    }

}
