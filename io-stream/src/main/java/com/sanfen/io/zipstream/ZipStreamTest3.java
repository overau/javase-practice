package com.sanfen.io.zipstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩流压缩文件夹
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/02 11:08
 */
public class ZipStreamTest3 {

    public static void main(String[] args) throws IOException {
        // 1.压缩文件夹
        File src = new File("io-stream\\data");
        // 2.压缩包的父级路径
        File destParent = src.getParentFile();
        // 3.压缩包的路径
        File dest = new File(destParent, src.getName() + ".zip");
        // 4.创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        // 5.获取src中的每一个文件，变成ZipEntry对象，放入到压缩包中
        toZip(src, zos, src.getName());
        // 6.释放资源
        zos.close();
    }

    /**
     * 获取src中的每一个文件，变成ZipEntry对象，放入到压缩包中
     * @param src 数据源
     * @param zos 压缩流
     * @param name 压缩包内部的路径
     */
    public static void toZip(File src,  ZipOutputStream zos, String name) throws IOException {
        File[] files = src.listFiles();
        if (Objects.isNull(files) || files.length == 0){
            // 在压缩包中创建空文件夹
            // (" /")表示创建一个文件夹
            ZipEntry entry = new ZipEntry(name + " /");
            zos.putNextEntry(entry);
            zos.closeEntry();
            return;
        }
        for (File file : files) {
            if (file.isFile()){
                // 变成ZipEntry对象:(压缩包内部的路径)
                ZipEntry entry = new ZipEntry(name + "\\" + file.getName());
                System.out.println(entry);
                zos.putNextEntry(entry);
                // 读取文件中的数据，写入到压缩包
                FileInputStream fis = new FileInputStream(file);
                int b;
                while ((b = fis.read()) != -1){
                    zos.write(b);
                }
                fis.close();
                zos.closeEntry();
            } else {
                // 递归
                toZip(file, zos, name + "\\" + file.getName());
            }
        }
    }

}
