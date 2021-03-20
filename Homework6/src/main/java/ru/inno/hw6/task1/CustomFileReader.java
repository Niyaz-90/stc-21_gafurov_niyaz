package ru.inno.hw6.task1;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CustomFileReader {
    private List<String> list;
    private final String fileForRead;
    private final String fileForWrite;

    public CustomFileReader(String fileForWrite, String fileForRead) {
        this.fileForRead = fileForRead;
        this.fileForWrite = fileForWrite;
        this.list = new LinkedList<>();
    }

    public List<String> getList() {
        return list;
    }

    public void readFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileForRead))){
            while (reader.read() != -1){

                String lineWithoutComma = reader.readLine().replaceAll(",", "");
                String lineWithoutDot = lineWithoutComma.replaceAll("\\pP", "");
                String[] words = lineWithoutDot.split(" ");
                list.addAll(Arrays.asList(words));

            }
        } catch ( IOException e ){
            System.out.println(e.getMessage());
        }
    }

    public void sort(){
        list.sort(String::compareTo);
    }
    public void writeToFile(){
        try (Writer writer = new FileWriter(fileForWrite)){
            for (String word :
                    list) {
                writer.write(word + "\n");
            }

        } catch (IOException e){
            e.getMessage();
        }
    }
}
