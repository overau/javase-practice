package com.sanfen.threadpool;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/09 10:39
 */
public class ThreadPoolTest4 {

    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
    }

}
