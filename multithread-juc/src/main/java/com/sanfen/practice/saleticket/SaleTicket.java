package com.sanfen.practice.saleticket;

/**
 * 卖电影票
 * 需求：一共有1000张电影票，可以在两个窗口领取，假设每次领取的时间为3000毫秒
 * 要求：请用多线程模拟卖票过程并打印剩余电影票的数量
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 12:24
 */
public class SaleTicket {

    /**
     * 电影票的数量
     */
    private static int ticket = 1000;

    public static void main(String[] args) {
        Runnable task = () -> {
            while (true) {
                synchronized (SaleTicket.class) {
                    System.out.println("(" + Thread.currentThread().getName() + ")剩余电影票: " + ticket);
                    if (ticket == 0) {
                        break;
                    }
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket--;
                }
            }
        };

        Thread t1 = new Thread(task, "窗口1");
        Thread t2 = new Thread(task, "窗口2");
        t1.start();
        t2.start();
    }

}
