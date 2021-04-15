package ru.inno.hw8.task1;

import java.util.Random;

/*
Дан массив случайных чисел. Написать программу для вычисления факториалов всех элементов
 массива. Использовать пул потоков для решения задачи.

 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[100];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        FactarialCalculator calculator = new FactarialCalculator(numbers);
        calculator.calculate();
    }
}
