package com.sanfen.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 接收消息
 * @author HeJin
 * @version 1.0
 * @since 2023/04/09 15:35
 */
public class ReceiveMessage {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(10086);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                InetAddress.getByName("127.0.0.1"), 10086);
        while (true){
            socket.receive(packet);
            String str = new String(bytes, 0, packet.getLength());
            System.out.println("接收到消息: " + str);
            if ("886".equals(str)){
                break;
            }
        }
        socket.close();
    }

}
