package com.hit.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            while (true) {
                new ClientSocket(serverSocket.accept()).start();
                System.out.println("Client Connected");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
