package com.xs.server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            Socket client = server.accept();
            new Thread(new ServerThread(client)).start();
        }
    }
}
