package ru.inno.hw6.task1;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class CustomFileReader {
    private Set<String> list;
    private final String fileForRead;
    private final String fileForWrite;

    public CustomFileReader(String fileForWrite, String fileForRead) {
        this.fileForRead = fileForRead;
        this.fileForWrite = fileForWrite;
        this.list = new TreeSet<>();

    }

    public Set<String> getList() {
        return list;
    }

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileForRead))) {
            while (reader.read() != -1) {

                String lineWithoutDot = reader.readLine().replaceAll("\\pP", "").toLowerCase();
                String[] words = lineWithoutDot.split(" ");
                for (String line : words) {
                    if (!"".equals(line) & !list.contains(line)) {
                        list.add(line);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileForWrite))) {
            for (String word : list) {
                writer.write(word + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
