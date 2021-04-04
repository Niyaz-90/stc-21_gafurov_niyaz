package ru.inno.hw11.task1;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    private Socket socket;
    private DataOutputStream toServer;
    private volatile BufferedReader fromServer;
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


    volatile Thread sendMessage = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("sendmessages is run");


                while (true) {
                    System.out.println("Введите сообщение: ");
                    String message = consoleReader.readLine();
                    toServer.writeUTF(message + "\n");
                    toServer.flush();

                    if ("quit".equals(message)) {
                        consoleReader.close();
                        fromServer.close();
                        toServer.close();
                        socket.close();
                        break;
                    }
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

                    message = fromServer.readLine();
                    System.out.println(message);


                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    });

}
