package ru.inno.hw.ex1.model;

public class Cat extends Pet{
    public Cat(PetType petType, String nickname, Person person, int weight) {
        super(petType, nickname, person, weight);
        System.out.println("cat is created");
    }
    public Cat(PetType petType, String nickname) {
        super(petType, nickname);
    }
}
