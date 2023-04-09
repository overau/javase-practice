package com.sanfen.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送数据
 * @author HeJin
 * @version 1.0
 * @since 2023/04/09 13:42
 */
public class SendMessageTest {

    public static void main(String[] args) throws IOException {
        // 1.创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        // 2.打包数据
        String str = "hello";
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;
        DatagramPacket packet = new DatagramPacket(str.getBytes(), str.length(), address, port);
        // 3.发送数据
        socket.send(packet);
        // 4.释放资源
        socket.close();
    }

}
