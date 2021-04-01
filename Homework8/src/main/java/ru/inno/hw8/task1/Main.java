package ru.inno.hw8.task1;

import java.util.Random;
import java.util.Scanner;

/*
Дан массив случайных чисел. Написать программу для вычисления факториалов всех элементов
 массива. Использовать пул потоков для решения задачи.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Random random = new Random();
        int[] numbers = new int[30];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
        FactarialCalculator calculator = new FactarialCalculator(numbers);
        calculator.calculate();

    }
}
