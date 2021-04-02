package ru.inno.hw11.task1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    Socket socket = new Socket("localhost", 34642);
    PrintWriter toServer = new BufferedOutputStream(
            new OutputStreamWriter(socket.getOutputStream()));
    BufferedReader fromServer = new BufferedInputStream(new InputStreamReader(socket.getInputStream()));


    public void sendMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи сообщение");
        String message = scanner.nextLine();
        toServer.println(message);
    }

    Runnable task = () -> {
        while (true){
            String message = fromServer.readLine();
            if (message != null){
                System.out.println(message);
            }
        }
    }
}
