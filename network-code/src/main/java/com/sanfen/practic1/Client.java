package com.sanfen.practic1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/14 16:40
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10086);
        OutputStream os = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        // 输入"886"表示结束发送
        while (true){
            System.out.println("请输入: ");
            String line = scanner.nextLine();
            if ("886".equals(line)){
                break;
            }
            os.write(line.getBytes());
        }
        os.close();
        socket.close();
    }

}
