package ru.inno.hw6.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    private  List<String> wordsArray;
    private static Random random = new Random();
    private File file;

    public Generator(List<String> wordsArray) {
        this.wordsArray = new ArrayList<>();
        this.file = new File("newFile.txt");
    }

    public void generateWords(int arraySize){
        int count = 0;
        while (count != arraySize){
            int wordSize = random.nextInt(16);
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < wordSize; i++){
                sb.append((char) random.nextInt(26) + 65);
                // stringBuilder.append((char)random.nextInt(номер буквы в таблице));?????
            }
            wordsArray.add(String.valueOf(sb));
            count++;
        }
    }

    public void generateText(){
        int fileSize = random.nextInt(50000) + 150000;
        while (file.length() != fileSize){
            int paragraphSize = random.nextInt(21);
            for (int i = 0; i < paragraphSize; i++){
                int sentenceSize = random.nextInt(16);
                for (int j = 0; j < sentenceSize; j++){
                    /*...Writer(uotputStream).write*/wordsArray.get(j);
                }
            }

        }

    }

    public void generateReadyFile(){

    }

    public void generateLastWord(int size){

    }
}
