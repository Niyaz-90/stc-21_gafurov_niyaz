package ru.inno.hw11.task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    protected static List<SocketThread> users;
    Scanner scanner = new Scanner(System.in);

    public void start() {

        try {
            ServerSocket serverSocket = new ServerSocket(34642);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("пользователь " + socket.getInetAddress() + "подключился к серверу");
                SocketThread socketThread = new SocketThread(socket);
                socketThread.setUsername();
                users.add(socketThread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
