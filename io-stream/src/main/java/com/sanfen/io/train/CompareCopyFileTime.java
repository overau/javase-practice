package com.sanfen.io.train;

import java.io.*;

/**
 * 拷贝文件耗时对比
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 12:30
 */
public class CompareCopyFileTime {

    public static void main(String[] args) throws IOException {
        File src = new File("io-stream\\a.txt");
        long start = System.currentTimeMillis();
        copyFile1(src, new File("io-stream\\a1.txt"));
        long end = System.currentTimeMillis();
        System.out.println("================================================");
        System.out.println("字节流的基本流, 一次读写一个字节: " + (end - start));
        System.out.println("================================================");

        start = System.currentTimeMillis();
        copyFile2(src, new File("io-stream\\a2.txt"));
        end = System.currentTimeMillis();
        System.out.println("字节流的基本流, 一次读写一个字节数组: " + (end - start));
        System.out.println("================================================");

        start = System.currentTimeMillis();
        copyFile3(src, new File("io-stream\\a3.txt"));
        end = System.currentTimeMillis();
        System.out.println("字节缓冲, 一次读写一个字节: " + (end - start));
        System.out.println("================================================");

        start = System.currentTimeMillis();
        copyFile4(src, new File("io-stream\\a4.txt"));
        end = System.currentTimeMillis();
        System.out.println("字节缓冲, 一次读写一个字节数组: " + (end - start));
    }

    /**
     * 字节流的基本流: 一次读写一个字节
     */
    public static void copyFile1(File src, File dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        int b;
        while ((b = fis.read()) != -1){
            fos.write(b);
        }
        fos.close();
        fis.close();
    }

    /**
     * 字节流的基本流: 一次读写一个字节数组
     */
    public static void copyFile2(File src, File dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
    }

    /**
     * 字节缓冲流: 一次读写一个字节
     */
    public static void copyFile3(File src, File dest) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        int b;
        while ((b = bis.read()) != -1){
            bos.write(b);
        }
        bos.close();
        bis.close();
    }

    /**
     * 字节缓冲流: 一次读写一个字节数组
     */
    public static void copyFile4(File src, File dest) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
    }

}
