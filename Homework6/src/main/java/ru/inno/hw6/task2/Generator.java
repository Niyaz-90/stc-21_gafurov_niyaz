package ru.inno.hw6.task2;

import java.io.*;
import java.util.Random;

public class Generator {
    private static Random random = new Random();
    private final char[] punctMarksArray = {'.', '!', '?'};  // как понять (.|!|?)+" ".   + и "" тоже считаются?

    public Generator() {
    }

    public String generateWord() {

        int wordSize = random.nextInt(16) + 1;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < wordSize; i++) {
            sb.append((char) (random.nextInt(26) + 65));
        }
        return String.valueOf(sb).toLowerCase();
    }


    public void getFiles(String path, int n, int size, String[] words, int probability) throws IOException {
        int filesCount = 0;
        while (filesCount != n) {
            File dir = new File(path);
            dir.mkdir();
            File file = new File(path, "resultFile" + filesCount + ".txt");
            file.createNewFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                StringBuilder sentenceBuilder = new StringBuilder();
                StringBuilder wordBuilder = new StringBuilder();

                //пока не достигли требуемой длины файла
                while (file.length() <= size) {
                    int paragraphSize = random.nextInt(21) + 1;

                    //пока не достигли требуемой длины абзаца
                    for (int i = 0; i < paragraphSize; i++) {
                        int sentenceSize = random.nextInt(16) + 1;

                        // флаг - содержит предложение запятую или нет
                        boolean containsComma = random.nextBoolean();

                        // флаг - удовлетворяет условию вероятности(слово из массива)
                        boolean containsArraysWord = Math.random() <= 1.0 / probability;

                        // пока не достигли требуемой длины предложения
                        for (int j = 0; j < sentenceSize; j++) {

                            // если попали в диапазон вероятности
                            if (containsArraysWord) {
                                wordBuilder.append(" " + words[random.nextInt(words.length)]);
                            }

                            // положение запятой в предложении
                            int commaIndex = random.nextInt(sentenceSize);

                            // генерируем слово из списка
                            wordBuilder.append(" " + generateWord());

                            if (sentenceSize == 1) {
                                wordBuilder.setCharAt(1, Character.toUpperCase(wordBuilder.charAt(1)));
                                wordBuilder.append(punctMarksArray[random.nextInt(punctMarksArray.length)]);
                                wordBuilder.setLength(0);
                                continue;
                            }

                            //если оно первое, то первую букву делаем заглавной
                            else if (j == 0) {
                                wordBuilder.setCharAt(1, Character.toUpperCase(wordBuilder.charAt(1)));
                            }

                            // если последнее, то поставить точку. Со switch - case не получается т.к. нужна константа
                            else if (j == sentenceSize - 1) {
                                wordBuilder.append(punctMarksArray[random.nextInt(punctMarksArray.length)]);
                            }

                            // если предложение содержит запятую - поставить её
                            else if (containsComma & j == commaIndex) {
                                wordBuilder.append(",");
                            }

                            // добавляем слово к предложению
                            sentenceBuilder.append(wordBuilder);
                            wordBuilder.setLength(0);

                        }

                        writer.write(sentenceBuilder.toString());

                        sentenceBuilder.setLength(0);
                    }

                    writer.write("\r\n");

                }

                filesCount++;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
