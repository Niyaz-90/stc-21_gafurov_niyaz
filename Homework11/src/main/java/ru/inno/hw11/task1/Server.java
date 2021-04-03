package ru.inno.hw11.task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    protected volatile static List<SocketThread> users = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Server() {
    }

    public void start() {

        try {
            ServerSocket serverSocket = new ServerSocket(34642);
            while (true) {
                Socket socket = serverSocket.accept();
                Thread newThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("пользователь " + socket.getInetAddress() + "подключился к серверу");

                        SocketThread socketThread = new SocketThread(socket);
                        socketThread.setUsername();
                        users.add(socketThread);
                        socketThread.start();
                    }
                });
                newThread.start();

//                socketThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
