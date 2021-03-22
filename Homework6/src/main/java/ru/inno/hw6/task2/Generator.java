package ru.inno.hw6.task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
    private List<String> wordsArray;
    private static Random random = new Random();
    private File file;
    private Writer writer;
    private final char[] punctMarksArray = {'.', '!', '?'};  // как понять (.|!|?)+" ". + и "" тоже считаются?

    public Generator(List<String> wordsArray) {
        this.wordsArray = new ArrayList<>();
        this.file = new File("newFile.txt");
        try {
            this.writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] generateWords(int arraySize) {
        int count = 0;
        while (count != arraySize) {
            int wordSize = random.nextInt(16);
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < wordSize; i++) {
                sb.append((char) random.nextInt(26) + 65);
            }
            wordsArray.add(String.valueOf(sb));
            count++;
        }
        return wordsArray.toArray(new String[0]);
    }

    // TODO: 22.03.2021 заменить все wordsArray на words(из параметров), разобраться с вероятностью
    public void getFiles(String path, int n, int size, String[] words, int probability) {
        try (Writer writer = new FileWriter(path)) {
            StringBuilder sentenceBuilder = new StringBuilder("");
            String wordForAppend = "";
            StringBuilder wordBuilder = new StringBuilder(wordForAppend);
//            int fileSize = size;

            int filesCount = 0;
            while (filesCount != n) {
                //пока не достигли требуемой длины файла
                while (file.length() != size) {
                    int paragraphSize = random.nextInt(21);

                    //пока не достигли требуемой длины абзаца
                    for (int i = 0; i < paragraphSize; i++) {
                        int sentenceSize = random.nextInt(16);

                        // флаг - содержит предложение запятую или нет
                        boolean containsComma = random.nextBoolean();

                        // пока не достигли требуемой длины предложения
                        for (int j = 0; j < sentenceSize; j++) {

                            // положение запятой в предложении
                            int commaIndex = random.nextInt(sentenceSize - 2);

                            // выбираем слово из списка
                            wordForAppend = " " + wordsArray.get(random.nextInt(wordsArray.size()) + 1);


                            //если оно первое, то первую букву делаем заглавной
                            if (j == 0) {
                                wordBuilder.setCharAt(0, Character.toUpperCase(wordForAppend.charAt(0)));
                            }
                            // если последнее, то поставить точку. Со switch - case не получается т.к. нужна константа
                            else if (j == sentenceSize - 1) {
                                wordBuilder.append(random.nextInt(punctMarksArray.length));
                            }

                            // если предложение содержит запятую - поставить её под нужным индексом
                            else if (containsComma & j == commaIndex) {
                                wordBuilder.append(",");
                            }

                            // добавляем слово к предложению
                            sentenceBuilder.append(wordBuilder);

                        }
                    }
                    writer.write(String.valueOf(sentenceBuilder));
                }

                filesCount++;
            }

        } catch (IOException e) {
            e.getMessage();
        }

    }

    public void generateReadyFile() {

    }

    public void generateLastWord(int size) {

    }
}
