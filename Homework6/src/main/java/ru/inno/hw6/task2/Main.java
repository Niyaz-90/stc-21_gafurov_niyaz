package ru.inno.hw6.task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("newFile.txt");
//        Writer writer = null;
        try {


//            file.createNewFile();
//            FileOutputStream fos = new FileOutputStream("/file.txt");
            System.out.println(file.length());
            Writer writer = new FileWriter(file, true);
            writer.write("Hello world");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.length());
        String h = "Hello world";


        char[] harray = h.toCharArray();
        byte count = 0;
        for (char byt : harray){
            count += (long) byt;
        }
        System.out.println(count);
//        long kb =
    }
}
