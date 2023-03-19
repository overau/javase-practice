package com.sanfen.ui;

import javax.swing.*;

/**
 * 注册界面
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 13:46
 */
public class RegisterJframe extends JFrame {

    public RegisterJframe(){
        this.setSize(488, 500);
        // 设置标题
        this.setTitle("拼图 注册");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置游戏关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 显示界面
        this.setVisible(true);
    }

}
