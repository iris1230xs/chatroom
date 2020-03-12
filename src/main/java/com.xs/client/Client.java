package com.xs.client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // Client用TCP连接Server，在本地端口12345
        Socket client = new Socket("127.0.0.1", 12345);
        // 读取键盘输入
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // 获取client的输入流，用来接收从服务端传过来的数据
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // 获取client的输出流，用来发送给服务端的数据
        PrintStream out =  new PrintStream(client.getOutputStream());
        while (true) {
            // 读取一行键盘输入
            String str = input.readLine();
            // 第一条命令: /login user_name 或者 /quit
            if (str.startsWith("/login ")) {
                // 传送给服务端
                out.print(str);
            } else if (str.equals("/quit")) {
                // 关闭键盘输入和客户端Socket
                input.close();
                client.close();
            } else {
                System.out.println("Invalid Command");
            }
            try {
                // 从服务器接收数据
                String res = in.readLine();
                System.out.println(res);
            } catch (SocketTimeoutException e) {
                System.out.println("Time out, no response");
            }
            input.close();
            client.close();
        }
    }
}
