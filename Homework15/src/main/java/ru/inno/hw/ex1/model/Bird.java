package ru.inno.hw.ex1.model;

public class Bird extends Pet{
    public Bird(String petType, String nickname, Person person, int weight) {
        super(petType, nickname, person, weight);
        System.out.println("bird is created");
    }


}
