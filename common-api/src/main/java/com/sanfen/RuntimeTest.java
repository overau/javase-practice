package com.sanfen;

import java.io.IOException;

/**
 * Runtime
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 12:57
 */
public class RuntimeTest {

    public static void main(String[] args) throws IOException {
        // 获取Runtime对象
        Runtime runtime = Runtime.getRuntime();
        // 获取CPU核数
        int processors = runtime.availableProcessors();
        System.out.println("CPU线程数: " + processors);
        // 获取最大内存
        long maxMemory = runtime.maxMemory();
        System.out.println("JVM能从系统中获取的总内存: " + maxMemory / (1024 * 1024));
        long totalMemory = runtime.totalMemory();
        // 获取已经获取内存
        System.out.println("JVM已经获取的内存: " + totalMemory / (1024 * 1024));
        // 剩余内存大小
        long freeMemory = runtime.freeMemory();
        System.out.println("JVM剩余的内存: " + freeMemory / (1024 * 1024));
        // 运行cmd命令
        runtime.exec("notepad");
        // 停止虚拟机
        runtime.exit(1);
        System.out.println("看看我执行了吗?");
    }

}
