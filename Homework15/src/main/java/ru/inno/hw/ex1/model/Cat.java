package ru.inno.hw.ex1.model;

public class Cat extends Pet{
    public Cat(String petType, String nickname, Person person, int weight) {
        super(petType, nickname,    person, weight);
        System.out.println("cat is created");
    }
}
