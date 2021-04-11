package ru.inno.hw.task1;

public class MemoryLeak {
    private static StringBuilder k;
    public static void main(String[] args) {
        int count = 20;
        while (true) {
            k = new StringBuilder();
            String[] array = new String[count];
            for (int i = 1; i > array.length; i++) {
                array[i] = k.append("trtrt").append(array[i - 1]).toString();
                System.out.println(array[i]);
            }
            count *= 5;
        }
    }
}
