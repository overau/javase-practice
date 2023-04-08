package com.sanfen.practice.oddnum;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 13:11
 */
public class OddNumTest {

    public static void main(String[] args) {
        OddNum task = new OddNum();
        Thread t1 = new Thread(task, "线程1");
        Thread t2 = new Thread(task, "线程2");
        t1.start();
        t2.start();
    }

}
