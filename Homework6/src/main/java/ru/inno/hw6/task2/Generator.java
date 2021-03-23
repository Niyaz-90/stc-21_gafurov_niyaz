package ru.inno.hw6.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    private static Random random = new Random();
//    private File file;
    private Writer writer;
    private final char[] punctMarksArray = {'.', '!', '?'};  // как понять (.|!|?)+" ".   + и "" тоже считаются?

    public Generator() {
//        this.file = new File("newFile.txt");
//        try {
//            this.writer = new FileWriter(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public String generateWord() {

        int wordSize = random.nextInt(16);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < wordSize; i++) {
            sb.append((char)(random.nextInt(26) + 65));
        }
        return String.valueOf(sb).toLowerCase();
    }

    // TODO: 22.03.2021 заменить все wordsArray на words(из параметров), разобраться с вероятностью
    public void getFiles(String path, int n, int size, String[] words, int probability) throws IOException {
        int filesCount = 0;
        while (filesCount != n) {
            File dir = new File(path);
            dir.mkdir();
            File file = new File(path, "resultFile" + filesCount + ".txt");
            file.createNewFile();
            try (Writer writer = new FileWriter(file)) {
                StringBuilder sentenceBuilder = new StringBuilder();
                StringBuilder wordBuilder = new StringBuilder(" ");


                //пока не достигли требуемой длины файла
                while (file.length() <= size) {
                    int paragraphSize = random.nextInt(20) + 1;

                    //пока не достигли требуемой длины абзаца
                    for (int i = 0; i < paragraphSize; i++) {
                        int sentenceSize = random.nextInt(16);

                        // флаг - содержит предложение запятую или нет
                        boolean containsComma = random.nextBoolean();

                        // флаг - удовлетворяет условию вероятности(слово из массива)
                        boolean containsArraysWord = Math.random() <= 1.0 / probability;


                        // <<<---

                        // пока не достигли требуемой длины предложения
                        for (int j = 0; j < sentenceSize; j++) {

                            // если попали в диапазон вероятности
                            if (containsArraysWord) {
                                wordBuilder.append(" " + words[random.nextInt(words.length)]);
                                continue;
                            }

                            // положение запятой в предложении
                            int commaIndex = random.nextInt(sentenceSize);

                            // генерируем слово из списка
                            wordBuilder.append(" " + generateWord());


                            //если оно первое, то первую букву делаем заглавной
                            if (j == 0) {
                                wordBuilder.setCharAt(1, Character.toUpperCase(wordBuilder.charAt(1)));
                            }
                            // если последнее, то поставить точку. Со switch - case не получается т.к. нужна константа
                            else if (j == sentenceSize - 1) {
                                wordBuilder.append(random.nextInt(punctMarksArray.length));
                            }

                            // если предложение содержит запятую - поставить её
                            else if (containsComma & j == commaIndex) {
                                wordBuilder.append(",");
                            }

                            // добавляем слово к предложению
                            sentenceBuilder.append(wordBuilder);

                        }
                        writer.write(String.valueOf(sentenceBuilder));
                        sentenceBuilder.setLength(0);
                    }
//                    if (int i < paragraphSize - 1) {
                        writer.write("\r\n -->");
//                    }

                    // перенос каретки и абзац
                }

                filesCount++;


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void generateReadyFile() {

    }

    public void generateLastWord(int size) {

    }
}
