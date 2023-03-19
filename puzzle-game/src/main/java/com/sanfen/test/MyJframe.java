package com.sanfen.test;

import com.sanfen.ui.GameConstants;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 17:57
 */
public class MyJframe extends JFrame implements MouseListener{

    public MyJframe() {
        this.setSize(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT);
        this.setTitle("事件演示");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        JButton jButton = new JButton("点我呀");
        jButton.setBounds(0, 0, 100, 50);
        // 给按钮绑定鼠标事件
        jButton.addMouseListener(this);


        this.getContentPane().add(jButton);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
