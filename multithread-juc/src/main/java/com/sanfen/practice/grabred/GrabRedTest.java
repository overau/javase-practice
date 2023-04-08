package com.sanfen.practice.grabred;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 14:08
 */
public class GrabRedTest {

    public static void main(String[] args) {
        GrabRed grabRed = new GrabRed();

        new Thread(grabRed, "张三").start();
        new Thread(grabRed, "李四").start();
        new Thread(grabRed, "王五").start();
        new Thread(grabRed, "赵六").start();
        new Thread(grabRed, "秦七").start();
    }

}
