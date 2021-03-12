package ru.inno.hw.ex1;

public class HelloWorld_NPE {
    public static void main(String[] args) {
        String s = "hello world!";
        System.out.println(s);
        s.toUpperCase();
    }
}
