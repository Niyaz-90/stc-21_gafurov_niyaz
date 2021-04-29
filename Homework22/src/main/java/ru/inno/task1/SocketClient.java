package ru.inno.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    private  static Logger logger = LoggerFactory.getLogger(SocketClient.class);
    private String username;
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
            logger.info("Введите своё имя");
            while (true){
                username = consoleReader.readLine();
                if ("quit".equals(username)){
                    logger.warn("Неверное имя пользователя. Имя не может быть \"quit\"");
                } else{
                    logger.info("HELLO " + username);
                    toServer.write(username + "\n");
                    toServer.flush();
                    break;
                }
            }
            receiveMessage.start();
            sendMessage.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Thread sendMessage = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                logger.info("sendmessage is run");

                while (true) {
                    System.out.println("Введите сообщение: ");
                    String message = consoleReader.readLine();
                    toServer.write(message + "\n");
                    toServer.flush();
                    if ("quit".equals(message)) {
                        consoleReader.close();
                        receiveMessage.interrupt();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    Thread receiveMessage = new Thread(new Runnable() {
        @Override
        public void run() {
            logger.info("receiver is run");
            try {
                while (true) {
                    if (receiveMessage.isInterrupted()) {
                        fromServer.close();
                        toServer.close();
                        socket.close();
                        break;
                    } else {
                        String message = fromServer.readLine();
                        logger.info(message);
                    }
                }
            } catch (IOException e) {
                logger.info(e.getMessage());
            }
        }
    });
}
