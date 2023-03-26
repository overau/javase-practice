package com.sanfen.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * 在当前模块下的aaa文件夹中创建一个a.txt文件
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 12:48
 */
@Slf4j
public class FilePractice01 {

    public static void main(String[] args) throws IOException {
        // 1.创建目录
        File dirs = new File("io-stream\\aaa");
        if (!dirs.exists()){
            boolean isMkdirs = dirs.mkdirs();
            if (!isMkdirs){
                log.error("创建文件夹失败, 路径: {}", dirs.getAbsolutePath());
                return;
            }
        }
        // 2.创建文件
        File file = new File(dirs, "a.txt");
        if (file.exists()) {
            boolean isDelete = file.delete();
            if (!isDelete){
                log.error("删除文件失败, 路径: {}, 文件名: {}", file.getParent(), file.getName());
            }
        } else {
            boolean isNewFile = file.createNewFile();
            if (!isNewFile){
                log.error("创建新文件失败, 路径: {}, 文件名: {}", file.getParent(), file.getName());
            }
            log.info("文件创建成功, 路径: {}, 文件名: {}", file.getParent(), file.getName());
        }
    }

}
