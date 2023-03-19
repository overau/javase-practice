package com.sanfen.ui;

import javax.swing.*;

/**
 * 登录界面
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 13:46
 */
public class LoginJframe extends JFrame {

    public LoginJframe(){
        this.setSize(488, 430);
        // 设置标题
        this.setTitle("拼图 登录");
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
