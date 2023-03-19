package com.sanfen.test;

import com.sanfen.ui.GameConstants;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 17:57
 */
public class MyJframe2 extends JFrame implements KeyListener {

    public MyJframe2() {
        this.setSize(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT);
        this.setTitle("事件演示");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        // 界面绑定鼠标事件
        this.addKeyListener(this);

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("键盘按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开键盘");
        int keyCode = e.getKeyCode();
        System.out.println("keyCode = " + keyCode);
    }
}
