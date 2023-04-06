package com.sanfen.ui;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.sanfen.domain.User;
import com.sanfen.util.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.List;

/**
 * 登录界面
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 13:46
 */
public class LoginJframe extends JFrame implements MouseListener {

    /**
     * 创建一个集合存储正确的用户名和密码
     * 从文件加载已经注册的用户数据
     */
    static List<User> userList;

    /**
     * 登录按钮
     */
    JButton login = new JButton();

    /**
     * 注册按钮
     */
    JButton register = new JButton();

    /**
     * 用户名输入框
     */
    JTextField username = new JTextField();

    /**
     * 密码输入框
     */
    JPasswordField password = new JPasswordField();

    /**
     * 验证码输入框
     */
    JTextField code = new JTextField();

    /**
     * 生成的验证码显示组件
     */
    JLabel rightCode = new JLabel();

    /**
     * 生成的验证码
     */
    String codeStr = RandomUtil.randomNumbers(6);

    public LoginJframe() {
        // 加载最新的用户数组
        File file = new File((RegisterConstants.USER_REGISTER_DATA));
        userList = FileUtils.loadUsersFromDir(file);
        //初始化界面
        initJframe();

        //在这个界面中添加内容
        initView();

        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initView() {
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon(LoginConstants.USERNAME_IMAGE));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon(LoginConstants.PASSWORD_IMAGE));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon(LoginConstants.CODE_IMAGE));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //验证码的输入框
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        rightCode.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        rightCode.setForeground(Color.MAGENTA);
        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 100, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //5.添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon(LoginConstants.LOGIN_BUTTON_IMAGE));
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);

        //6.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon(LoginConstants.REGISTER_BUTTON_IMAGE));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);

        // 添加事件
        login.addMouseListener(this);
        register.addMouseListener(this);
        rightCode.addMouseListener(this);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon(LoginConstants.BACKGROUND_IMAGE));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }


    public void initJframe() {
        //设置宽高
        this.setSize(488, 430);
        //设置标题
        this.setTitle("拼图游戏 V1.0登录");
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //居中
        this.setLocationRelativeTo(null);
        //置顶
        this.setAlwaysOnTop(true);
        //取消内部默认布局
        this.setLayout(null);
    }


    /**
     * 要展示用户名或密码错误
     *
     * @param content 内容
     */
    public void showJdialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source == login) {
            login.setIcon(new ImageIcon(LoginConstants.LOGIN_PRESS_BUTTON_IMAGE));
        } else if (source == register) {
            register.setIcon(new ImageIcon(LoginConstants.REGISTER_PRESS_BUTTON_IMAGE));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        if (source == login) {
            // 登录逻辑
            login.setIcon(new ImageIcon(LoginConstants.LOGIN_BUTTON_IMAGE));
            // 没有输入用户名或密码
            String usernameText = username.getText();
            String passwordText = new String(password.getPassword());
            if (StrUtil.isBlank(usernameText) || StrUtil.isBlank(passwordText)) {
                this.showJdialog("请输入用户名和密码");
                return;
            }
            // 校验验证码
            if (!code.getText().equals(codeStr)) {
                this.showJdialog("验证码错误!");
                code.setText("");
                codeStr = RandomUtil.randomNumbers(6);
                rightCode.setText(codeStr);
                return;
            }
            // 校验用户名和密码
            for (User user : userList) {
                if (user.getUsername().equals(usernameText) &&
                        user.getPassword().equals(SecureUtil.sha1(passwordText))) {
                    try {
                        // 判断用户是否被锁定(密码连续输错3次)
                        int passwordErrorCount = this.getPasswordErrorCount(usernameText);
                        if (passwordErrorCount >= 3) {
                            this.showJdialog("密码连续输错3次，当前账号被锁定!");
                            this.setVisible(false);
                            System.exit(0);
                        }
                        // 密码输入成功，清除密码连续输错次数的记录
                        this.setPasswordErrorCount(usernameText, 0);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    this.showJdialog("登录成功!");
                    this.setVisible(false);
                    new GameJframe();
                    return;
                }
            }
            // 用户已经注册，记录连续密码错误次数到文件
            if(userList.stream().map(User::getUsername).anyMatch(u -> u.equals(usernameText))){
                try {
                    int passwordErrorCount = this.getPasswordErrorCount(usernameText);
                    this.setPasswordErrorCount(usernameText, (++passwordErrorCount));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            this.showJdialog("用户名或者密码错误!");
            code.setText("");
            codeStr = RandomUtil.randomNumbers(6);
            rightCode.setText(codeStr);
        } else if (source == register) {
            // 注册逻辑
            register.setIcon(new ImageIcon(LoginConstants.REGISTER_BUTTON_IMAGE));
            this.setVisible(false);
            new RegisterJframe();
        } else if (source == rightCode) {
            // 更换验证码
            codeStr = RandomUtil.randomNumbers(6);
            rightCode.setText(codeStr);
        }
    }

    /**
     * 根据账户名获取密码连续输错次数
     * <p>文件名称: 用户名</p>
     * <p>文件内容: 密码连续输错次数</p>
     *
     * @param username 用户账号
     * @return 密码连续输错次数
     */
    private int getPasswordErrorCount(String username) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(LoginConstants.USER_PASSWORD_ERROR + username + ".txt"));
        String countStr = br.readLine();
        br.close();
        return Integer.parseInt(countStr);
    }

    /**
     * 保存密码连续错误次数到文件
     *
     * @param username 用户账号
     * @param count    密码连续错误次数
     */
    private void setPasswordErrorCount(String username, int count) throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter(new File(LoginConstants.USER_PASSWORD_ERROR, username + ".txt")));
        bw.write(count + "");
        bw.close();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
