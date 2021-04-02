package ru.inno.hw11.task1;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    ExecutorService clientThread = Executors.newCachedThreadPool();
    private List<SocketClient> users = new ArrayList<>();
    Socket user = new Socket();
    Socket newUser = new Socket();

    public void start(){
        ServerSocket serverSocket = new ServerSocket(34642);
        while (true){
            Runnable newUserThread = () => {
                if (newUser != null){
                    newUser = serverSocket.accept();
                }
            }
            user = serverSocket.accept();

        }
    }



}
