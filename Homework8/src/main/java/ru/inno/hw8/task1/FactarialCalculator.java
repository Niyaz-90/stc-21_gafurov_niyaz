package ru.inno.hw8.task1;

import sun.nio.ch.ThreadPool;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactarialCalculator extends Thread {
    private volatile int[] array;
    private final ExecutorService service = Executors.newFixedThreadPool(4);

    public FactarialCalculator(int[] array) {
        this.array = array;

    }


    public void calculate() {
        for (int i : array) {

            service.submit(() -> {
                int count = 1;
                System.out.println(Thread.currentThread().getName() + "   i = " + i);
                BigInteger result = new BigInteger("1");
                while (count <= i) {
                    result = result.multiply(BigInteger.valueOf(count));
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

}
