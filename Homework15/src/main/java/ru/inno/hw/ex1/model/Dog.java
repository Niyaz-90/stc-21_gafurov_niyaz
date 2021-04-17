package ru.inno.hw.ex1.model;

public class Dog extends Pet{
    public Dog(String petType, String nickname, Person person, int weight) {
        super(petType, nickname, person, weight);
        System.out.println("dog is created");
    }
}
