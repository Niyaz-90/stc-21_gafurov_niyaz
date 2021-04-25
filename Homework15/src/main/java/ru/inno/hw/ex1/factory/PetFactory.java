package ru.inno.hw.ex1.factory;

import ru.inno.hw.ex1.model.*;

public class PetFactory {
    private PetType petType;
    public static Pet create(PetType petType, String nickname, Person person, int weight){
        switch (petType){
            case Dog:
                return new Dog(PetType.Dog, nickname, person, weight);
            case Cat:
                return new Cat(PetType.Cat, nickname, person, weight);
            case Bird:
                return new Bird(PetType.Bird, nickname, person, weight);
            default:
                return null;
        }
    }

    public static Pet create(PetType petType, String nickname){
        switch (petType){
            case Dog:
                return new Dog(PetType.Dog, nickname);
            case Cat:
                return new Cat(PetType.Cat, nickname);
            case Bird:
                return new Bird(PetType.Bird, nickname);
            default:
                return null;
        }
    }
}
