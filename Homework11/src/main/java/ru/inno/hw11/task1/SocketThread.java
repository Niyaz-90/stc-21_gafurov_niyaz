package ru.inno.hw11.task1;

import java.io.*;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.Scanner;

import ru.inno.hw11.task1.Server;

public class SocketThread extends Thread {
    private String username;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private Scanner scanner= new Scanner(System.in);

    public SocketThread(Socket socket) {
        try {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUsername() {
        try {
            out.write("Введите своё имя");
//            out.flush();
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
                for (SocketThread user : Server.users) {
                    user.sendMessage(username + " говорит " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message){
        try {
            out.write(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
