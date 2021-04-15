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

    public FactarialCalculator(int[] array) {
        this.array = array;
        this.factorialsArray = new ArrayList<>();
        this.maxValue = Arrays.stream(array).max().getAsInt();
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
