package ru.inno.hw.ex1;

public class HelloWorld_thrExc {
    public static void main(String[] args) {
        String hello = "Hello World";
        if (hello.equals("Hello World")){
            throw new IllegalArgumentException("hello don't equals HelloWorld");
        } else
            System.out.println(hello);
    }
}
