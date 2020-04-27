package com.saillen.study.socket;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : saillen
 * @date: 2020/4/28
 **/
public class BIOSocketServer {
    public static void main(String[] args) throws Exception {
        BIOSocketServer demo = new BIOSocketServer();
        demo.start(7777);
    }

    public void start(int port) throws Exception {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        Socket so = server.accept();
        InputStream ipt = so.getInputStream();
        System.out.println(ipt.read());
    }
}
