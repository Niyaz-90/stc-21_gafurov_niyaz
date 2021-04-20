package ru.inno.hw8.task1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactarialCalculator extends Thread {

    private volatile int[] array;
    private final ExecutorService service = Executors.newFixedThreadPool(4);
    private volatile List<BigInteger> factorialsArray;
    private int maxValue;
    private final LinkedList<BigInteger> part1;
    private final LinkedList<BigInteger> part2;
    private final LinkedList<BigInteger> part3;
    private final LinkedList<BigInteger> part4;
    private int arrayPartSize;

    public FactarialCalculator(int[] array) {
        this.array = array;
        this.factorialsArray = new ArrayList<>();
        this.maxValue = Arrays.stream(array).max().getAsInt();
        this.part1 = new LinkedList<>();
        this.part2 = new LinkedList<>();
        this.part3 = new LinkedList<>();
        this.part4 = new LinkedList<>();
    }

    public void calculate() {
        calculateMaxFactorial();
        for (int i : array) {
            service.submit(() -> {
                int count = 1;
//                System.out.println(Thread.currentThread().getName() + "   i = " + i);
                BigInteger result = new BigInteger("1");
                while (count <= i) {
                    result = factorialsArray.get(count);
                    count++;
                }
            });
        }
        service.shutdown();
        try {
            Thread.currentThread().join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            printAll();

    }
    public void calculateMaxFactorial() {

        if (maxValue % 4 > 0) {
            arrayPartSize = (maxValue / 4) + 1;
        } else {
            arrayPartSize = (maxValue / 4);
        }
        Thread task1 = new Thread( new Runnable() {
            @Override
            public void run() {
                BigInteger result = new BigInteger("1");
                for (int i = 0; i < arrayPartSize; i++) {
                    result = result.multiply(BigInteger.valueOf(i + 1));
                    part1.add(i, result);
                }
            }
        });

        Thread task2 = new Thread( new Runnable() {
            @Override
            public void run() {
                BigInteger result = BigInteger.valueOf(arrayPartSize);
                for (int i = 0; i < arrayPartSize; i++) {
                    result = result.multiply(BigInteger.valueOf(i + 2 + arrayPartSize));
                    part2.add(i, result);
                }
            }
        });

        Thread task3 = new Thread( new Runnable() {
            @Override
            public void run() {
                BigInteger result = BigInteger.valueOf(2 * arrayPartSize);
                for (int i = 0; i < arrayPartSize; i++) {
                    result = result.multiply(BigInteger.valueOf(i  + 1 +(2 * arrayPartSize)));
                    part3.add(i, result);
                }
            }
        });

        Thread task4 = new Thread( new Runnable() {
            @Override
            public void run() {
                BigInteger result = BigInteger.valueOf(2 * arrayPartSize);
                for (int i = 0; i < arrayPartSize;i++) {
                    result = result.multiply(BigInteger.valueOf(i  + 1 + (3 * arrayPartSize)));
                    part4.add(i, result);
                }
            }
        });
        task1.start();
        task2.start();
        task3.start();
        task4.start();

        try {
            task4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        refreshArrays();
        factorialsArray.addAll( part1);
        System.err.println("p1 = " + part1.size() + " , p2 = " + part2.size() + " , p3 = " + part3.size() + " , p4 = " + part4.size());
        factorialsArray.addAll(part2);
        factorialsArray.addAll(part3);
        factorialsArray.addAll(part4);
    }
    public void printAll(){

        for (BigInteger number : factorialsArray) {
            System.out.println(number);
        }
    }

    private void refreshArrays(){
        //не получается делать несколькими потоками т.к. part2 использует макс значение
        //part1, part3 использует макс значение part2, part4 использует макс значение part3.
        //Т.е каждый поток должен ждать окончания предыдущего, смысл в многопоточности пропадает
        BigInteger part1MaxValue = part1.peekLast();
        for (int i = 0; i < part2.size(); i++) {
           part2.set(i, part2.get(i).multiply(part1MaxValue));
        }
        System.out.println("==" + part1MaxValue);

        BigInteger part2MaxValue = part2.peekLast();
        for (int i = 0; i < part3.size(); i++) {
            part3.set(i, part3.get(i).multiply(part2MaxValue));
        }
        System.out.println("==" + part2MaxValue);

        BigInteger part3MaxValue = part3.peekLast();
        for (int i = 0; i < part4.size(); i++) {
            part4.set(i, part4.get(i).multiply(part3MaxValue));
        }
        System.out.println("==" + part3MaxValue);
    }
}
