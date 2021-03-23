package ru.inno.hw6.task1;


/*
* Задание 1. Написать программу, читающую текстовый файл. Программа должна составлять
*  отсортированный по алфавиту список слов, найденных в файле и сохранять его в файл-результат.
* Найденные слова не должны повторяться, регистр не должен учитываться. Одно слово в разных
* падежах – это разные слова.*/

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filepath = "readhere.txt";
        String newFile = "sorted.txt";
        CustomFileReader fileReader = new CustomFileReader(newFile, filepath);
        fileReader.readFile();
        fileReader.sort();
        for (String word :
                fileReader.getList()) {
            System.out.println(word);
        }
        fileReader.writeToFile();



    }
}
