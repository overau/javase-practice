package com.sanfen.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程池
 * @author HeJin
 * @version 1.0
 * @since 2023/04/09 9:30
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) {
        // 1.获取线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 2.提交任务
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "==>" + i);
            }
        };
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);
        // 3.销毁线程池(一般不会销毁，随程序一起24小时)
        // pool.shutdown();
    }

}
