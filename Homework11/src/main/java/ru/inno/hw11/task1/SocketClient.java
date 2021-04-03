package ru.inno.hw11.task1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    private Socket socket;
    private DataOutputStream toServer;
    private BufferedReader fromServer;
    private BufferedReader consoleReader;

    public SocketClient(Socket socket) {
        try {
            this.socket = socket;
            this.toServer = new DataOutputStream(socket.getOutputStream());
            this.fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.consoleReader = new BufferedReader(new InputStreamReader(System.in));
            recieveMessage.start();
            sendMessage.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    Thread sendMessage = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("sendmessages is run");
//            Scanner scanner = new Scanner(System.in);

            try {
                while (true) {
                    System.out.println("Введите сообщение: ");
                    String message = consoleReader.readLine();
                    toServer.writeUTF(message + "\n");
                    toServer.flush();
//                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    });

    Thread recieveMessage = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("reciever is run");
            String message = null;
            try {
            while (true) {

//                    if (fromServer.) {
                        message = fromServer.readLine();
//                        System.out.println(message);
//                    }

                if ("quit".equals(message)) {
                    System.out.println(message);
                    break;
                }
            }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    });

}
