package com.sanfen.io.train;

import java.io.*;

/**
 * 验证软件是否激活
 * (1)3次免费运行次数
 * (2)超过3次弹出提示
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 13:02
 */
public class ActivateCheck {

    public static void main(String[] args) throws IOException {
        // 1.判断激活文件是否存在，不存在说明第一次使用，创建激活次数文件
        File file = new File("io-stream\\activate.txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new RuntimeException("程序运行异常!");
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("1");
                bw.close();
                System.out.println("欢迎使用本软件，第1次免费使用~");
                return;
            }
        }

        // 2.文件存在，说明是已经使用过，判断使用次数
        BufferedReader br = new BufferedReader(new FileReader(file));
        String strCount = br.readLine();
        br.close();
        int count = Integer.parseInt(strCount);
        if (++count > 3) {
            System.out.println("本软件只能免费使用3次，欢迎你注册会员后继续使用!");
        } else {
            System.out.println("欢迎使用本软件，第" + count + "次免费使用~");
        }

        // 使用次数记录到文件
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(count + "");
        bw.close();
    }

}
