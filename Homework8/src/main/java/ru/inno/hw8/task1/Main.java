package ru.inno.hw8.task1;

import java.util.Random;

/*
Дан массив случайных чисел. Написать программу для вычисления факториалов всех элементов
 массива. Использовать пул потоков для решения задачи.

 Фактариал вычисленный для одного числа, сохраняется
  в массиве factarialsArray(в классе FactarialCalculator)
 */
public class Main {
    public static void main(String[] args) {


        Random random = new Random();
        int[] numbers = new int[30];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
        FactarialCalculator calculator = new FactarialCalculator(numbers);
        calculator.calculate();

    }
}
