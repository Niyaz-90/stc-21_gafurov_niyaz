package ru.inno.hw11.task1;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    private Socket socket;
    private PrintWriter toServer;
    private volatile BufferedReader fromServer;
    private BufferedReader consoleReader;

    public SocketClient(Socket socket) {
        try {
            this.socket = socket;
            this.toServer = new PrintWriter(socket.getOutputStream());
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
                    toServer.write(message + "\n");
                    toServer.flush();

                    if ("quit".equals(message)) {
                        consoleReader.close(); // TODO: 05.04.2021 проблема начинается здеся!
                        recieveMessage.interrupt();
                        break;
                    } else if ("Введите ваше имя".equals(fromServer.readLine())) {
                        while (true) {

                            // TODO: 05.04.2021 доделать "вместо имени введут "quit""

                            String name = consoleReader.readLine();
                            if ("quit".equals(name)) {
                                System.out.println("name cannot be \"quit\"");
                            } else {
                                toServer.write(name);
                                toServer.flush();
                            }
                        }
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
            try {
                while (true) {
                    if (recieveMessage.isInterrupted()) {
                        fromServer.close();
                        toServer.close();
                        socket.close();
                        break;
                    } else {
                        String message = fromServer.readLine();
                        System.out.println(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    });

}
