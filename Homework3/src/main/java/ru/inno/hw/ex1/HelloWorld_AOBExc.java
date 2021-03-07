package ru.inno.hw.ex1;

public class HelloWorld_AOBExc {
    public static void main(String[] args) {

        String[] a = new String[5];
        for (int i = 0; i < 6; i++) {
            a[i] = "hello world " + (i + 1);
            System.out.println(a[i]);
        }
    }
}
