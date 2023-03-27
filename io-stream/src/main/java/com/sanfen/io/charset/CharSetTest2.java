package com.sanfen.io.charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 编码和解码
 * @author HeJin
 * @version 1.0
 * @since 2023/03/27 16:15
 */
public class CharSetTest2 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 1.编码
        String str = "鸟为什么会飞";
        byte[] bytes1 = str.getBytes();
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));

        // 解码
        System.out.println("==========================================================");
        String s1 = new String(bytes1);
        System.out.println(s1);
        String s2 = new String(bytes1, "GBK");
        System.out.println(s2);
        String s3 = new String(bytes2);
        System.out.println(s3);
        String s4 = new String(bytes2, "GBK");
        System.out.println(s4);
    }

}
