package ru.inno.hw.ex2;

import ru.inno.hw.ex2.exception.NegativeNumberException;

import java.util.Random;

public class Numbers {

    public static void main(String[] args) {
        Random random = new Random();

        int[] a = random.ints(500000).toArray();
        for (int j : a) {
            try {
                if (j > 0) {
                    double sqNumber = Math.sqrt(j);
                    int wholePart = (int) sqNumber;
                    if (Math.pow(wholePart, 2.0) == j) {
                        System.out.println(j);
                    }
                } else {
                    throw new NegativeNumberException();
                }
            } catch (NegativeNumberException e) {
                System.out.println("negative number");
            }
        }
    }

}

