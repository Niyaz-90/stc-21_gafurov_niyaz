package ru.inno.hw.ex1;

import java.util.*;

/*
Задание 1. Написать класс MathBox, реализующий следующий функционал:

        - Конструктор на вход получает массив Number. Элементы не могут повторяться.
        Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
        - Существует метод summator, возвращающий сумму всех элементов коллекции.
        - Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте
        элементов на делитель, являющийся аргументом метода. Хранящиеся в объекте данные полностью
        заменяются результатами деления.
        - Необходимо правильно переопределить методы toString, hashCode, equals,
        чтобы можно было использовать MathBox для вывода данных на экран и хранение объектов этого класса
        в коллекциях (например, hashMap). Выполнение контракта обязательно!
        - Создать метод, который получает на вход Integer и если такое значение есть в коллекции,
        удаляет его.
*/

public class MainMath {
    public static void main(String[] args) {
        //исходные данные
        Number[] numbers1 = {3, 6.8, 1L, 4F, 3.0};
        Number[] numbers2 = {3, 78, 12L, 8, 3.0F};
        Number[] numbers3 = {5L, 3.4F, 1, 67, 3.3};
        MathBox mathBox1 = new MathBox(numbers1);
        MathBox mathBox2 = new MathBox(numbers2);
        MathBox mathBox3 = new MathBox(numbers3);

        // проверка корректной работы методов
        System.out.println(mathBox1.summator());
        mathBox2.remove(8);
        mathBox3.splitter(4);
        System.out.println(mathBox1.getInstanceId());
        System.out.println(mathBox2.getInstanceId());
        System.out.println(mathBox3.getInstanceId());

        // хранение объектов MathBox в коллекции
        HashMap<Integer, MathBox> mathBoxMap = new HashMap<>();
        mathBoxMap.put(mathBox1.getInstanceId(), mathBox1);
        mathBoxMap.put(mathBox2.getInstanceId(), mathBox2);
        mathBoxMap.put(mathBox3.getInstanceId(), mathBox3);

        System.out.println(mathBoxMap.size());
        System.out.println(mathBoxMap.toString());
        System.out.println(mathBoxMap.get(1).toString());
    }
}

