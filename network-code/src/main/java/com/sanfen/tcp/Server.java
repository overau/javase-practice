package com.sanfen.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * tcp服务端
 * @author HeJin
 * @version 1.0
 * @since 2023/04/13 19:52
 */
public class Server {

    public static void main(String[] args) throws IOException {
        // 1.创建对象
        ServerSocket serverSocket = new ServerSocket(10000);
        // 2.监听客户端连接
        Socket socket = serverSocket.accept();
        // 3.连接通道中获取输入流
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while ((b = isr.read()) != -1){
            System.out.print((char) b);
        }
        // 4.释放资源
        is.close();
        socket.close();
        serverSocket.close();
    }

}
