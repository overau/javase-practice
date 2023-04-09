package com.sanfen.network1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类的使用
 * @author HeJin
 * @version 1.0
 * @since 2023/04/09 13:24
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("192.168.0.103");
        System.out.println(address);

        InetAddress address1 = InetAddress.getByName("DESKTOP-O3EA7R0");
        System.out.println(address1);

        System.out.println("==============================");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
        System.out.println(address.getCanonicalHostName());
    }

}
