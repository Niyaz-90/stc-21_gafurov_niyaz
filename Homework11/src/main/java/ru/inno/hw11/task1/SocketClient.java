package ru.inno.hw11.task1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    private Socket socket;
    private PrintWriter toServer;
    private BufferedReader fromServer;

    public SocketClient(Socket socket) {
        try {
            this.socket = socket;
            this.toServer = new PrintWriter(socket.getOutputStream());
            this.fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    Runnable sendMessagesTask = () -> {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сообщение: ");
        String message = scanner.nextLine();
        toServer.println(message);
    };

    Runnable recieveMessagesTask = () -> {
        System.out.println("reciever is run");
        while (true){
            String message = null;
            try {
                message = fromServer.readLine();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!"quit".equals(message)){
                System.out.println(message);
            }
        }
    };
}
