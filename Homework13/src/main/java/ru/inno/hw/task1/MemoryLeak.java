package ru.inno.hw.task1;

import java.util.Scanner;

public class MemoryLeak {
    private static StringBuilder k;
    public static void main(String[] args) {
        int count = 10;
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        while (true) {
            k = new StringBuilder();
            String[] array = new String[count];
            for (int i = 0; i < array.length; i++) {
                array[i] = k.append("trtrt").toString();
                System.out.println("free memory: " + Runtime.getRuntime().freeMemory());
                if (i%2 == 0){
                    array[i] = array[i] + k.append("wwqqw");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count *= 2;
        }
    }
}
