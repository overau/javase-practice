package com.sanfen.practice.oddnum;

/**
 * 同时开启两个线程，共同获取1-100之间的所有数字
 * 要求：输出所有的奇数
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 13:09
 */
public class OddNum implements Runnable {

    private int count = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (OddNum.class) {
                if (count > 100) {
                    break;
                }
                if (count % 2 != 0) {
                    System.out.println("(" + Thread.currentThread().getName() + "): " + count);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                count++;
            }
        }
    }

}
