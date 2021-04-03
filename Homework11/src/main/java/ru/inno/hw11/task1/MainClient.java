package ru.inno.hw11.task1;

import java.io.IOException;
import java.net.Socket;

public class MainClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 34642);
            SocketClient client = new SocketClient(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
