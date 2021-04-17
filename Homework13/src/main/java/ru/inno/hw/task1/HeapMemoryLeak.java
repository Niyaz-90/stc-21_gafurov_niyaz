package ru.inno.hw.task1;

public class HeapMemoryLeak {
    private static StringBuilder k;
    public static void main(String[] args) {
        int count = 10;
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
            count *= 2;
        }
    }
}
