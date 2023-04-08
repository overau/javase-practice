package com.sanfen.practice.grabred;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 14:08
 */
public class GrabRedTest2 {

    public static void main(String[] args) {
        GrabRed2 grabRed2 = new GrabRed2();

        new Thread(grabRed2, "张三").start();
        new Thread(grabRed2, "李四").start();
        new Thread(grabRed2, "王五").start();
        new Thread(grabRed2, "赵六").start();
        new Thread(grabRed2, "秦七").start();
    }

}
