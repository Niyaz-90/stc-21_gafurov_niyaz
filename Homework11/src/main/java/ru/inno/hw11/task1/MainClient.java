package ru.inno.hw11.task1;

import java.io.IOException;
import java.net.Socket;

public class MainClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 34642);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SocketClient client = new SocketClient(socket);
        client.recieveMessagesTask.run();
        client.sendMessagesTask.run();
    }
}
