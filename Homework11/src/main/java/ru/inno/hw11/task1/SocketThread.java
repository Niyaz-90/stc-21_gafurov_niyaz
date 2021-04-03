package ru.inno.hw11.task1;

import java.io.*;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.Scanner;

import ru.inno.hw11.task1.Server;

public class SocketThread extends Thread {
    public String username;
    private Socket socket;
    private BufferedReader in;
    private DataOutputStream out;
    private Scanner scanner= new Scanner(System.in);

    public SocketThread(Socket socket) {
        try {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUsername() {
        try {
            sendMessage("Введите ваше имя");
            this.username = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        while (true){
            try {
                message = in.readLine();
                System.out.println("в run()  SocketThread'a");
                for (SocketThread user : Server.users) {
                    user.sendMessage(" говор от другого потока " + message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message){
        try {
            out.writeUTF(message + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
