package com.saillen.study.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author : saillen
 * @date: 2020/4/28
 **/
public class SocketClientDemo {
    public static void main(String[] args) throws IOException {
        Socket so = new Socket();
        so.connect(new InetSocketAddress(7777));
        OutputStream o = so.getOutputStream();
        o.write(2);
        o.close();
        so.close();
    }
}
