package ru.inno.hw7.task2;

import java.io.*;
import java.util.Random;

public class Generator {
    private static Random random = new Random();
    private final char[] punctMarksArray = {'.', '!', '?'};  // . ИЛИ ! ИЛИ ? и плюс пробел в конце


    public String generateWord() {

        int wordSize = random.nextInt(16) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordSize; i++) {
            sb.append((char) (random.nextInt(26) + 97));
        }
        return sb.toString();
    }


    public void getFiles(String path, int n, int size, String[] words, int probability) {

        int filesCount = 0;
        while (filesCount != n) {
            File dir = new File(path);
            dir.mkdir();
            File file = new File(path, "resultFile" + filesCount + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {


                //пока не достигли требуемой длины файла
                while (file.length() <= size) {
                    int paragraphSize = random.nextInt(21) + 1;

                    //пока не достигли требуемой длины абзаца
                    for (int i = 0; i < paragraphSize; i++) {
                        StringBuilder sentenceBuilder = new StringBuilder();
                        int sentenceSize = random.nextInt(16) + 1;

                        // флаг - содержит предложение запятую или нет
                        boolean containsComma = random.nextBoolean();
                        int commaIndex = -1;

                        // положение запятой в предложении
                        if (containsComma & sentenceSize > 1) {
                            commaIndex = random.nextInt(sentenceSize) - 1;
                        }

                        // флаг - удовлетворяет условию вероятности(слово из массива)
                        // для каждого предложения
                        boolean containsArraysWord = Math.random() <= 1.0 / probability;
                        boolean isPresent = false;
                        int wordPosition = random.nextInt(sentenceSize);

                        // пока не достигли требуемой длины предложения
                        for (int j = 0; j < sentenceSize; j++) {
                            StringBuilder wordBuilder = new StringBuilder();

                            // если попали в диапазон вероятности
                            if (containsArraysWord & !isPresent & wordPosition == j) {
                                wordBuilder.append(" ").append(words[random.nextInt(words.length)].toUpperCase());
                                isPresent = true;
//                                continue;
                            }



                            if (commaIndex != -1 & j == commaIndex) {
                                wordBuilder.append(",");
                            }
                            // генерируем слово из списка
                            wordBuilder.append(" " + generateWord());

//                            if (sentenceSize == 1) {
//                                wordBuilder.setCharAt(1, Character.toUpperCase(wordBuilder.charAt(1)));
//                                wordBuilder.append(punctMarksArray[random.nextInt(punctMarksArray.length)]);
//                                continue;
//                            }
//
//                            //если оно первое, то первую букву делаем заглавной
//                            else if (j == 0) {
//                                wordBuilder.setCharAt(1, Character.toUpperCase(wordBuilder.charAt(1)));
//                            }
//
//                            // если последнее, то поставить точку
//                            else if (j == sentenceSize - 1) {
//                                wordBuilder.append(punctMarksArray[random.nextInt(punctMarksArray.length)]);
//                            }

                            // если предложение содержит запятую - поставить её


                            // добавляем слово к предложению
                            sentenceBuilder.append(wordBuilder);


                        }
                        sentenceBuilder.setCharAt(1, Character.toUpperCase(sentenceBuilder.charAt(1)));
                        sentenceBuilder.append(punctMarksArray[random.nextInt(punctMarksArray.length)]);

                        writer.write(sentenceBuilder.toString());


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
