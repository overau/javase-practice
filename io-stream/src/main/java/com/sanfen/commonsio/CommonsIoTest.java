package com.sanfen.commonsio;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileUtils工具类
 * @author HeJin
 * @version 1.0
 * @since 2023/04/02 12:01
 */
public class CommonsIoTest {

    public static void main(String[] args) throws IOException {
        File src = new File("io-stream\\a.txt");
        File dest = new File("io-stream\\b.txt");
        FileUtils.copyFile(src, dest);

        IOUtils.copy(new FileInputStream(src), new FileOutputStream(dest));
    }

}
