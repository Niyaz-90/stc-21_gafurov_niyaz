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
    private PrintWriter out;
    private Scanner scanner= new Scanner(System.in);

    public SocketThread(Socket socket) {
        try {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUsername() {
        try {
            sendMessage("Введите ваше имя");
            this.username = in.readLine();
            for (SocketThread user : Server.users) {
                user.sendMessage( username + " joined to this chat");
            }

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
                String[] messageLine = message.split(" ");
                switch (messageLine[0]){
                    case "quit":
                        out.close();
                        in.close();
                        socket.close();
                        for (SocketThread user : Server.users) {
                            if (user.equals(this)){
                                currentThread().interrupt();
                                continue;
                            }
                            user.sendMessage( username + " leave this chat");
                        }

                        break;
                    case "to":
                        for (SocketThread user : Server.users) {
                            if (user.username.equals(messageLine[1])){
                                user.sendMessage("from " + this.username + " " + message);
                                continue;
                            }
                            user.sendMessage( username + " leave this chat");
                        }
                    default:

                        for (SocketThread user : Server.users) {
                            if (user.equals(this)){
                                continue;
                            }
                            user.sendMessage( username + " говорит: " + message);
                        }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message){

            out.print(message + "\n");
            out.flush();

    }
}
