package com.sanfen.file;

import java.io.File;
import java.io.IOException;

/**
 * File常见的成员方法: 创建、删除
 * @author HeJin
 * @version 1.0
 * @since 2023/03/26 11:32
 */
public class FileTest3 {

    public static void main(String[] args) throws IOException {
        // 1.createNewFile创建新文件:
        // (1)当前路径文件不存在，会创建成功，返回true
        // (2)当前路径文件存在，创建失败，返回false
        // (3)该方法一定会创建文件，如果路径中不包含后缀名，则创建一个没有后缀的文件
        File file1 = new File("E:\\data\\ccc\\a.txt");
        boolean isCreate = file1.createNewFile();
        System.out.println(isCreate);

        // 2.mkdir创建文件夹:
        File file2 = new File("E:\\data\\ttt\\aaa");
        boolean isMkdirs = file2.mkdirs();
        System.out.println(isMkdirs);

        // 3.删除
        boolean isDelete = file2.delete();
        System.out.println(isDelete);
    }

}
