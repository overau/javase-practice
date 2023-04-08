package com.sanfen;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 11:42
 */
public class ProxyTest {

    public static void main(String[] args) {
        BigStar bigStar = new BigStar("鸡哥");
        Star proxy = ProxyUtil.createProxy(bigStar);
        String sing = proxy.sing("只因你太美");
        System.out.println(sing);
        System.out.println("=========================");
        proxy.dance();
    }

}
