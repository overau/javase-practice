package com.sanfen.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP接收数据
 * @author HeJin
 * @version 1.0
 * @since 2023/04/09 13:48
 */
public class ReceiveMessageTest {

    public static void main(String[] args) throws IOException {
        // 1.创建DatagramSocket对象，并绑定端口
        DatagramSocket socket = new DatagramSocket(10086);
        // 2.接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        // 阻塞方法
        socket.receive(packet);
        // 3.解析数据包
        System.out.println(packet.getAddress());
        System.out.println(packet.getLength());
        System.out.println(packet.getPort());
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        // 4.释放资源
        socket.close();
    }

}
