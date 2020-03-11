package com.xs.server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        Socket client = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("Please login");
    }
}
