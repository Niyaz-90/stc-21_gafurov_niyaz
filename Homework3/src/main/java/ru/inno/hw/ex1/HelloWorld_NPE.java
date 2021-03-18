package ru.inno.hw.ex1;

public class HelloWorld_NPE {
    public static void main(String[] args) {
        String s = "hello world!";
        s = null;
        System.out.println(s);
        s.toUpperCase();
    }
}
