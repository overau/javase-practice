package com.sanfen.io.zipstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 解压缩流
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 20:02
 */
public class ZipStreamTest1 {

    public static void main(String[] args) throws IOException {
        // 1.创建File表示要解压的压缩包
        File src = new File("io-stream\\data.zip");
        // 2.创建File表示要解压的目的地
        File dest = new File("io-stream");
        // 3.解压缩
        unzip(src, dest);
    }

    /**
     * 解压文件
     */
    public static void unzip(File src, File dest) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        // 获取zipEntry对象
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null){
            System.out.println(entry);
            if (entry.isDirectory()){
                // 文件夹: dest创建同样的文件夹
                File file = new File(dest, entry.toString());
                file.mkdirs();
            } else {
                // 文件: 读取压缩包文件，并存放到dest文件夹（层级目录）
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));
                int b;
                while ((b = zis.read()) != -1){
                    fos.write(b);
                }
                fos.close();
                // 表示压缩包中的一个文件处理完毕了
                zis.closeEntry();
            }
        }
        zis.close();
    }

}
