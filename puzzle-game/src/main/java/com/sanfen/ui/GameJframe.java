package com.sanfen.ui;

import cn.hutool.core.io.IoUtil;
import com.sanfen.domain.GameInfo;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.nio.file.Files;
import java.util.Random;

/**
 * 游戏主界面
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 13:44
 */
public class GameJframe extends JFrame implements KeyListener, ActionListener {

    /**
     * 空白方块在二维数组中的位置: x
     */
    int zeroX = 0;

    /**
     * 空白方块在二维数组中的位置: y
     */
    int zeroY = 0;

    /**
     * 创建一个二维数组，用来管理数据
     * 加载图片的时候，会根据二维数组中的数据进行加载
     */
    int[][] data = new int[GameConstants.X_COUNT][GameConstants.Y_COUNT];

    /**
     * 存储正确数据的二维数组
     */
    int[][] win = {
            {1, 5, 9, 13},
            {2, 6, 10, 14},
            {3, 7, 11, 15},
            {4, 8, 12, 0},
    };

    /**
     * 图片路径
     */
    String path = GameConstants.DEFAULT_IMAGE_FOLDER;

    /**
     * 统计步数
     */
    int step = 0;

    /**
     * JMenuItem
     */
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");

    JMenu saveJmenu = new JMenu("存档");
    JMenu loadJmenu = new JMenu("读档");

    JMenuItem saveItem0 = new JMenuItem("存档0(空)");
    JMenuItem saveItem1 = new JMenuItem("存档1(空)");
    JMenuItem saveItem2 = new JMenuItem("存档2(空)");
    JMenuItem saveItem3 = new JMenuItem("存档3(空)");
    JMenuItem saveItem4 = new JMenuItem("存档4(空)");

    JMenuItem loadItem0 = new JMenuItem("读档0(空)");
    JMenuItem loadItem1 = new JMenuItem("读档1(空)");
    JMenuItem loadItem2 = new JMenuItem("读档2(空)");
    JMenuItem loadItem3 = new JMenuItem("读档3(空)");
    JMenuItem loadItem4 = new JMenuItem("读档4(空)");

    /**
     * 更换图片
     */
    JMenuItem girlItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");

    public GameJframe() {
        // 初始化界面
        this.initJframe();

        // 初始化菜单
        this.initJmenuBar();

        // 加载存档数据
        this.getGameInfo();

        // 初始化数据
        this.initData();

        // 初始化图片
        this.initImage();

        // 显示界面
        this.setVisible(true);
    }

    /**
     * 初始化数据(打乱)
     */
    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random random = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = random.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                zeroX = i / 4;
                zeroY = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    /**
     * 初始化图片
     * 按照二维数组中管理的数据添加图片
     * 注意: 先加载的图片在上方，后加载的图片在下方
     */
    private void initImage() {
        // 清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        // 判断游戏是否胜利
        if (this.victory()) {
            ImageIcon bg = new ImageIcon(GameConstants.WIN_IMAGE);
            JLabel win = new JLabel(bg);
            win.setBounds(203, 283, bg.getIconWidth(), bg.getIconHeight());
            this.getContentPane().add(win);
            this.getContentPane().repaint();
        }

        // 添加步数统计
        JLabel stepCount = new JLabel("步数: " + step);
        stepCount.setBounds(50, 30, 500, 25);
        stepCount.setFont(new Font(null, Font.BOLD, 25));
        this.getContentPane().add(stepCount);

        // 添加拼图
        for (int i = 0; i < GameConstants.X_COUNT; i++) {
            for (int j = 0; j < GameConstants.Y_COUNT; j++) {
                // 获取当前加载图片的序号
                int num = data[i][j];
                // JLabel
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                jLabel.setBounds(i * GameConstants.IMAGE_WIDTH + 83, j * GameConstants.IMAGE_HEIGHT + 134,
                        GameConstants.IMAGE_WIDTH, GameConstants.IMAGE_HEIGHT);
                // 图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                // JLabel添加到界面
                this.getContentPane().add(jLabel);
            }
        }

        // 添加背景图片
        ImageIcon bg = new ImageIcon(GameConstants.BACKGROUND_IMAGE);
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        // 刷新界面
        this.getContentPane().repaint();
    }

    /**
     * 初始化菜单
     */
    private void initJmenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        // JMenu
        JMenu functionJmenu = new JMenu("功能");
        JMenu aboutJmenu = new JMenu("关于我们");

        // 更换图片
        JMenu changeImage = new JMenu("更换图片");
        changeImage.add(girlItem);
        changeImage.add(animalItem);
        changeImage.add(sportItem);

        //把5个存档，添加到saveJmenu中
        saveJmenu.add(saveItem0);
        saveJmenu.add(saveItem1);
        saveJmenu.add(saveItem2);
        saveJmenu.add(saveItem3);
        saveJmenu.add(saveItem4);

        //把5个读档，添加到loadJMenu中
        loadJmenu.add(loadItem0);
        loadJmenu.add(loadItem1);
        loadJmenu.add(loadItem2);
        loadJmenu.add(loadItem3);
        loadJmenu.add(loadItem4);

        // 将更换图片，重新游戏，重新登录，关闭游戏，存档，读档添加到“功能”选项当中
        functionJmenu.add(changeImage);
        functionJmenu.add(replayItem);
        functionJmenu.add(reLoginItem);
        functionJmenu.add(closeItem);
        functionJmenu.add(saveJmenu);
        functionJmenu.add(loadJmenu);

        aboutJmenu.add(accountItem);

        // 绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        // 更换图片的绑定事件
        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);
        // 存档读档
        saveItem0.addActionListener(this);
        saveItem1.addActionListener(this);
        saveItem2.addActionListener(this);
        saveItem3.addActionListener(this);
        saveItem4.addActionListener(this);
        loadItem0.addActionListener(this);
        loadItem1.addActionListener(this);
        loadItem2.addActionListener(this);
        loadItem3.addActionListener(this);
        loadItem4.addActionListener(this);

        // JMenu添加到JMenuBar
        jMenuBar.add(functionJmenu);
        jMenuBar.add(aboutJmenu);
        // 给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    /**
     * 加载游戏存档数据
     */
    private void getGameInfo() {
        File saveDir = new File(GameConstants.GAME_ARCHIVE_FOLDER);
        File[] saveFiles = saveDir.listFiles();
        if (saveFiles != null) {
            for (File file : saveFiles) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
                    GameInfo gameInfo = (GameInfo) ois.readObject();
                    ois.close();
                    // 修改(存档和读档item)上的展示信息
                    int index = file.getName().charAt(4) - '0';
                    saveJmenu.getItem(index).setText("存档" + index + "(" + gameInfo.getStep() + "步)");
                    loadJmenu.getItem(index).setText("存档" + index + "(" + gameInfo.getStep() + "步)");
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    /**
     * 初始化界面
     */
    private void initJframe() {
        // 设置界面宽高
        this.setSize(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT);
        // 设置标题
        this.setTitle(GameConstants.GAME_TITLE);
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置游戏关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认居中放置, 只有取消了才会按照XY轴的形势添加组件
        this.setLayout(null);
        // 给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 判断游戏是否胜利，如果胜利，直接结束
        if (this.victory()) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_Q) {
            // 删除界面全部图片
            this.getContentPane().removeAll();
            // 加载完整图片
            ImageIcon icon = new ImageIcon(path + "all.jpg");
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jLabel);
            // 加载背景图片
            ImageIcon bg = new ImageIcon(GameConstants.BACKGROUND_IMAGE);
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            // 刷新界面
            this.getContentPane().repaint();
        }
    }

    /**
     * 上移：是把空白区域下方的图片上移。
     * 下移：是把空白区域上方的图片下移。
     * 左移：是把空白区域右方的图片左移。
     * 右移：是把空白区域左方的图片右移。
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // 判断游戏是否胜利，如果胜利，直接结束
        if (this.victory()) {
            return;
        }
        int keyCode = e.getKeyCode();
        // 左:37 上:38 右:39 下:40 A:65  W:87  D:68 S:83
        // 左右移动: zeroX发生变化, zeroY不变
        // 上下移动: zeroY发生变化, zeroX不变
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            // 向左移动
            if (zeroX == GameConstants.X_COUNT - 1) {
                return;
            }
            data[zeroX][zeroY] = data[zeroX + 1][zeroY];
            data[zeroX + 1][zeroY] = 0;
            zeroX++;

            // 每移动一次，计步器+1
            step++;

            // 根据最新数组加载图片
            this.initImage();
        } else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            // 向上移动
            if (zeroY == GameConstants.Y_COUNT - 1) {
                return;
            }
            data[zeroX][zeroY] = data[zeroX][zeroY + 1];
            data[zeroX][zeroY + 1] = 0;
            zeroY++;

            // 每移动一次，计步器+1
            step++;

            // 根据最新数组加载图片
            this.initImage();
        } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            // 向右移动
            if (zeroX == 0) {
                return;
            }
            data[zeroX][zeroY] = data[zeroX - 1][zeroY];
            data[zeroX - 1][zeroY] = 0;
            zeroX--;

            // 每移动一次，计步器+1
            step++;

            // 根据最新数组加载图片
            this.initImage();
        } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
            // 向下移动
            if (zeroY == 0) {
                return;
            }
            data[zeroX][zeroY] = data[zeroX][zeroY - 1];
            data[zeroX][zeroY - 1] = 0;
            zeroY--;

            // 每移动一次，计步器+1
            step++;

            // 根据最新数组加载图片
            this.initImage();
        } else if (keyCode == KeyEvent.VK_Q) {
            // 松开Q，取消完整图片预览，加载数据
            this.initImage();
        } else if (keyCode == KeyEvent.VK_X) {
            // 一键通关
            data = new int[][]{
                    {1, 5, 9, 13},
                    {2, 6, 10, 14},
                    {3, 7, 11, 15},
                    {4, 8, 12, 0},
            };
            this.getContentPane().removeAll();
            // 加载胜利图片
            ImageIcon bg = new ImageIcon(GameConstants.WIN_IMAGE);
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            this.initImage();
        }
    }

    /**
     * 判断data数组中的数据跟win数组相同
     *
     * @return 全部相同，返回true。否则返回false
     */
    private boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == replayItem) {
            System.out.println("重新游戏");
            // 打乱二维数组中的数据
            this.initData();
            // 计步器清零
            step = 0;
            // 根据最新数据加载图片
            this.initImage();
        } else if (source == reLoginItem) {
            System.out.println("重新登录");
            // 关闭当前游戏界面
            this.setVisible(false);
            // 打开登录界面
            new LoginJframe();
        } else if (source == closeItem) {
            System.out.println("退出游戏");
            // 直接关闭虚拟机
            System.exit(0);
        } else if (source == accountItem) {
            System.out.println("公众号");
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon(GameConstants.ACCOUNT_IMAGE));
            jLabel.setBounds(0, 0, 258, 258);
            jDialog.add(jLabel);
            // 设置弹框大小
            jDialog.setSize(344, 344);
            // 弹框置顶
            jDialog.setAlwaysOnTop(true);
            // 弹框居中
            jDialog.setLocationRelativeTo(null);
            // 弹框不关闭则无法操作下面的界面
            jDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            // 显示弹框
            jDialog.setVisible(true);
        } else if (source == girlItem) {
            // 美女
            this.changeImage(GameConstants.GIRL_FOLDER);
        } else if (source == animalItem) {
            // 动物
            this.changeImage(GameConstants.ANIMAL_FOLDER);
        } else if (source == sportItem) {
            // 运动
            this.changeImage(GameConstants.SPORT_FOLDER);
        } else if (source == saveItem0 || source == saveItem1 || source == saveItem2 || source == saveItem3 || source == saveItem4) {
            // 获取当前哪个存档被点击了，获取其中的序号
            JMenuItem item = (JMenuItem) source;
            int index = item.getText().charAt(2) - '0';
            // 游戏的数据写到本地
            System.out.println("存档: " + GameConstants.GAME_ARCHIVE_FOLDER + "save" + index + ".data");
            try {
                FileOutputStream fos = new FileOutputStream(GameConstants.GAME_ARCHIVE_FOLDER + "save" + index + ".data");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                GameInfo gameInfo = new GameInfo(zeroX, zeroY, path, step, data);
                IoUtil.writeObj(oos, true, gameInfo);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            // 修改(存档和读档item)上的展示信息
            item.setText("存档" + index + "(" + step + "步)");
            loadJmenu.getItem(index).setText("存档" + index + "(" + step + "步)");
        } else if (source == loadItem0 || source == loadItem1 || source == loadItem2 || source == loadItem3 || source == loadItem4) {
            // 获取当前哪个存档被点击了，获取其中的序号
            JMenuItem item = (JMenuItem) source;
            int index = item.getText().charAt(2) - '0';
            System.out.println("读档: " + GameConstants.GAME_ARCHIVE_FOLDER + "save" + index + ".data");
            try {
                FileInputStream fis = new FileInputStream(GameConstants.GAME_ARCHIVE_FOLDER + "save" + index + ".data");
                ObjectInputStream ois = new ObjectInputStream(fis);
                GameInfo gameInfo = (GameInfo) ois.readObject();
                ois.close();
                fis.close();
                this.zeroX = gameInfo.getZeroX();
                this.zeroY = gameInfo.getZeroY();
                this.path = gameInfo.getPath();
                this.step = gameInfo.getStep();
                this.data = gameInfo.getData();
                // 刷新界面，加载游戏
                this.initImage();
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * 更换图片
     *
     * @param imagePath 图片路径
     */
    private void changeImage(String imagePath) {
        // 步数统计清零
        step = 0;

        File file = new File(imagePath);
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        int index = new Random().nextInt(files.length);
        path = files[index].getPath() + "\\";
        // 打乱二维数组
        this.initData();
        // 重新加载图片
        this.initImage();
    }
}
