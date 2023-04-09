package com.sanfen.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/09 15:32
 */
public class SendMessage {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入你要说的话: ");
            String str = scanner.nextLine();
            socket.send(new DatagramPacket(str.getBytes(), str.length(),
                    InetAddress.getByName("127.0.0.1"), 10086));
            if ("886".equals(str)){
                break;
            }
        }
        socket.close();
    }

}
