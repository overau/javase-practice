package com.sanfen.runtimegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Administrator
 */
public class MyJframe extends JFrame implements ActionListener {

    JButton yesBut = new JButton("帅爆了");
    JButton midBut = new JButton("一般般吧");
    JButton noBut = new JButton("不帅，有点磕碜");
    JButton dadButton = new JButton("饶了我吧!");

    public MyJframe(){
        initJframe();


        initView();


        //显示
        this.setVisible(true);
    }

    private void initView() {

        this.getContentPane().removeAll();

        dadButton.setBounds(50, 20, 100, 30);
        dadButton.addActionListener(this);
        dadButton.setVisible(false);
        this.getContentPane().add(dadButton);

        JLabel text = new JLabel("你觉得自己帅吗？");
        text.setFont(new Font("微软雅黑", Font.PLAIN,30));
        text.setBounds(120,150,300,50);


        yesBut.setBounds(200,250,100,30);
        midBut.setBounds(200,325,100,30);
        noBut.setBounds(160,400,180,30);

        yesBut.addActionListener(this);
        midBut.addActionListener(this);
        noBut.addActionListener(this);

        this.getContentPane().add(text);
        this.getContentPane().add(yesBut);
        this.getContentPane().add(midBut);
        this.getContentPane().add(noBut);

        this.getContentPane().repaint();
    }

    private void initJframe() {
        //设置宽高
        this.setSize(500,600);
        //设置标题
        this.setTitle("恶搞好基友");
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //置顶
        this.setAlwaysOnTop(true);
        //居中
        this.setLocationRelativeTo(null);
        //取消内部默认布局
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Runtime runtime = Runtime.getRuntime();
        if (source == yesBut){
            System.out.println("你的好基友点击了帅爆了");
            this.showJdialog("XXX，你太自信了，给你一点小惩罚");
            try {
                runtime.exec("shutdown -s -t 60");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            dadButton.setVisible(true);
        } else if (source == midBut) {
            System.out.println("你的好基友点击了一般般吧");
            this.showJdialog("XXX，你太自信了，给你一点小惩罚");
            try {
                runtime.exec("shutdown -s -t 60");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            dadButton.setVisible(true);
        } else if (source == noBut) {
            System.out.println("你的好基友点击了不帅");
            this.showJdialog("XXX，你还有自知之明的，给你一点小惩罚");
            try {
                runtime.exec("shutdown -s -t 60");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            dadButton.setVisible(true);
        } else if (source == dadButton) {
            this.showJdialog("XXX，这次饶了你");
            try {
                runtime.exec("shutdown -a");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    public void showJdialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(300, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }
}
