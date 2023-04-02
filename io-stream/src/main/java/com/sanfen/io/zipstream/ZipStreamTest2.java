package com.sanfen.io.zipstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩流压缩单个文件
 * @author HeJin
 * @version 1.0
 * @since 2023/04/02 10:52
 */
public class ZipStreamTest2 {

    public static void main(String[] args) throws IOException {
        File src = new File("io-stream\\a.txt");
        File dest = new File("io-stream");
        toZip(src, dest);
    }

    public static void toZip(File src, File dest) throws IOException {
        // 1.创建压缩流
        ZipOutputStream zos = new ZipOutputStream(
                Files.newOutputStream(new File(dest, "a.zip").toPath()));
        // 2.zipEntry对象
        ZipEntry entry = new ZipEntry(src.getName());
        // 3.zipEntry对象放到压缩包
        zos.putNextEntry(entry);
        // 4.src中的数据写入到压缩包中
        FileInputStream fis = new FileInputStream(src);
        int b;
        while ((b = fis.read()) != -1){
            zos.write(b);
        }

        // 5.关闭资源
        fis.close();
        zos.closeEntry();
        zos.close();
    }

}
