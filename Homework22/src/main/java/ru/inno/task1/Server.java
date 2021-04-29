package ru.inno.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    protected volatile static List<SocketThread> users = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(Server.class);

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
                        logger.info("пользователь " + socket.getInetAddress() + "подключился к серверу");
                        SocketThread socketThread = new SocketThread(socket);
                        users.add(socketThread);
                        socketThread.start();
                    }
                });
                newThread.start();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
