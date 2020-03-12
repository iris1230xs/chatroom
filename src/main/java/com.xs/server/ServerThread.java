package com.xs.server;

import java.io.*;
import java.net.*;

public class ServerThread implements Runnable {
    private Socket client = null;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // 获取该线程Socket的输入流，用来接收从客户端传来的数据
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取该线程Socket的输出流，用来发送给客户端的数据
        try {
            PrintStream out = new PrintStream(client.getOutputStream());
            out.println("Please login");
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
