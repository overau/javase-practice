package com.sanfen.smallproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 随机点名器
 * @author HeJin
 * @version 1.0
 * @since 2023/04/03 13:58
 */
public class RollCall01 {

    public static void main(String[] args) throws IOException {
        // 定义存放名字的集合
        List<String> names = new ArrayList<>();
        // 读取文件数据
        BufferedReader br = new BufferedReader(new FileReader("io-stream\\names.txt"));
        String line;
        while ((line = br.readLine()) != null){
            names.add(line.split("-")[0]);
        }
        // 打乱集合
        Collections.shuffle(names);
        System.out.println(names.get(0));
    }

}
