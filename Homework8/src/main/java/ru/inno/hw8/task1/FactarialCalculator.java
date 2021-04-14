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
    private volatile List<BigInteger> factarialsArray;
    private volatile List<Integer> tempArray;
    private volatile boolean isMaxFound = false;
    public FactarialCalculator(int[] array) {
        this.array = array;
        this.factarialsArray = new ArrayList<>();
        this.tempArray = new ArrayList<>();
    }
    public void calculate() {
        for (int i : array) {

            service.submit(() -> {
                int count = 1;
                System.out.println(Thread.currentThread().getName() + "   i = " + i);
                if (!isMaxFound) {
                    int number = Arrays.stream(array).max().getAsInt();
                    int numberCount = 1;
                    int threadCount = 5;
                    while (number % threadCount == 0) {
                        threadCount--;
                    }
                    int arrayPart = array.length / threadCount;
                    int currentRange = 0;
                    while (currentRange <= threadCount) {

                            Thread tr = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    for (int j = currentRange; j < arrayPart*(currentRange); j ++) {

                                        factarialsArray.set(j, );
                                    }

                                }
                            });
                        currentRange++;
                    }
                }
                BigInteger result = new BigInteger("1");
                while (count <= i) {
                    if (factarialsArray[count] != null) {
                        result = factarialsArray[count];
                    } else {
                        result = result.multiply(BigInteger.valueOf(count));
                        factarialsArray[count] = result;
                    }
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
    Runnable task1 = new Runnable() {
        int beginIndex = 0;
        int finishIndex = 24;
        //        int count = b;
        @Override
        public void run() {
            for (int i = beginIndex; i <= finishIndex; i++) {
                array[i] = beginIndex * (beginIndex + 1);
            }
        }
    };
    Runnable task2 = new Runnable() {
        int beginIndex = 25;
        int finishIndex = 49;
        @Override
        public void run() {
            for (int i = beginIndex; i <= finishIndex; i++) {
                array[i] = beginIndex * (beginIndex + 1);
            }
        }
    };
    Runnable task3 = new Runnable() {
        int beginIndex = 50;
        int finishIndex = 74;
        @Override
        public void run() {
            for (int i = beginIndex; i <= finishIndex; i++) {
                array[i] = beginIndex * (beginIndex + 1);
            }
        }
    };
    Runnable task4 = new Runnable() {
        int beginIndex = 75;
        int finishIndex;
        @Override
        public void run() {
            for (int i = beginIndex; i <= finishIndex; i++) {
                array[i] = beginIndex * (beginIndex + 1);
            }
        }
    };
    public void calculateMaxFactorial() {

        int count = 0;
        while (count < 4) {
            Thread tr = new Thread()
        }
    }

}
