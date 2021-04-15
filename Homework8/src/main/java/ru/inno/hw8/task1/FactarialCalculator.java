package ru.inno.hw8.task1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactarialCalculator extends Thread {
    private volatile int[] array;
    private final ExecutorService service = Executors.newFixedThreadPool(4);
    private volatile List<BigInteger> factorialsArray;
    private boolean isMaxFound = false;
    private int maxValue;
    private List<BigInteger> part1;
    private List<BigInteger> part2;
    private List<BigInteger> part3;
    private List<BigInteger> part4;
    private int arrayPartSize = 0;
    public FactarialCalculator(int[] array) {
        this.array = array;
        this.factorialsArray = new ArrayList<>();
        this.maxValue = Arrays.stream(array).max().getAsInt();
        this.part1 = new ArrayList<>();
        this.part2 = new ArrayList<>();
        this.part3 = new ArrayList<>();
        this.part4 = new ArrayList<>();
    }
    public void calculate() {
        factorialsArray.add(new BigInteger("0"));
        calculateMaxFactorial();
        for (int i : array) {
            service.submit(() -> {
                int count = 1;
                System.out.println(Thread.currentThread().getName() + "   i = " + i);
                BigInteger result = new BigInteger("1");
                while (count <= i) {
                    result = factorialsArray.get(count);
                    System.out.println("вычисление для i = " + i + " , результат вычисления "
                            + result + " потоком " + Thread.currentThread().getName());
                    count++;
                }
                System.out.println("*** Поток " + Thread.currentThread().getName()
                        + " доработал с результатом " + result);
            });
        }
        service.shutdown();
    }
    public void calculateMaxFactorial() {

        int arrayPartSize2 = maxValue % 4;
        if (maxValue % 4 > 0) {
            arrayPartSize = (maxValue / 4) + 1;
        } else {
            arrayPartSize = (maxValue / 4);
        }
        part1.add(new BigInteger("1"));
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < arrayPartSize; i++) {
                    BigInteger result = part1.get(i -1).multiply(BigInteger.valueOf(i));
                    part1.add(i, result);
                    System.out.println(i + " , result: " + result);
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                part2.add(arrayPartSize, part1.get(arrayPartSize - 1).multiply(BigInteger.valueOf(arrayPartSize)));
                for (int i = arrayPartSize + 1; i < 2 * arrayPartSize; i++) {
                    BigInteger result = part2.get(i - 1).multiply(BigInteger.valueOf(i ));
                    part2.add(i, result);
                    System.out.println(i + " , result: " + result);
                }
            }
        };

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                part3.add(2 * arrayPartSize, part2.get(2 * arrayPartSize - 1).multiply(BigInteger.valueOf(BigInteger.valueOf(2 * arrayPartSize)));
                for (int i = 2* arrayPartSize; i < 3 * arrayPartSize; i++) {
                    BigInteger result = part3.get(i).multiply(BigInteger.valueOf(i + 1));
                    part3.add(i, result);
                }
            }
        };

        Runnable task4 = new Runnable() {
            @Override
            public void run() {
                for (int i = 3 * arrayPartSize; i < array.length;i++) {
                    BigInteger result = part4.get(i).multiply(BigInteger.valueOf(i + 1));
                    part4.add(i, result);
                }
            }
        };
        task1.run();
        task2.run();
        task3.run();
        task4.run();
        factorialsArray.addAll(1, part1);
        factorialsArray.addAll(part2);
        factorialsArray.addAll(part3);
        factorialsArray.addAll(part4);
        if (!isMaxFound) {
            System.out.println(maxValue);
            factorialsArray.add(1, BigInteger.valueOf(1));
            Thread tr = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 2; j < factorialsArray.size(); j++) {
                        factorialsArray.add(j, factorialsArray.get(j - 1).multiply(BigInteger.valueOf(j)));
                    }
                }
            });
            tr.start();
            isMaxFound = true;
        }
    }
}
