package ru.inno.hw7.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sorted.txt"));
            while (reader.readLine() != null) {
                wordsList.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = wordsList.toArray(new String[0]);

        Generator generator = new Generator();
        String path = "resultPath";

        generator.getFiles(path, 3, 10, words, 10);

        System.out.println("that s all");
    }
}
