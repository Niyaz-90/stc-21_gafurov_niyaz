package ru.inno.hw8.task1;

import java.util.Arrays;
import java.util.Random;

/*
Дан массив случайных чисел. Написать программу для вычисления факториалов всех элементов
 массива. Использовать пул потоков для решения задачи.

 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt( 9) + 1;
        }
        System.out.println(Arrays.toString(numbers));
        FactarialCalculator calculator = new FactarialCalculator(numbers);
        calculator.calculate();
    }
}
