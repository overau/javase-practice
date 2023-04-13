package com.sanfen.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * tcp客户端
 * @author HeJin
 * @version 1.0
 * @since 2023/04/13 19:52
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 1.创建Socket对象
        Socket socket = new Socket("127.0.0.1", 10000);
        // 2.连接通道获取输出流
        OutputStream os = socket.getOutputStream();
        os.write("你好你好".getBytes());
        // 3.释放资源
        os.close();
        socket.close();
    }

}
