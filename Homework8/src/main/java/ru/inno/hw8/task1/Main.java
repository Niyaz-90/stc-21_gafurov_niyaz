package ru.inno.hw8.task1;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Random random = new Random();
//
        int[] numbers = new int[30];
//        int[] numbers = {5, 3, 2, 8, 10};
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
        FactarialCalculator calculator = new FactarialCalculator(numbers);
        calculator.calculate();


//
    }
}
