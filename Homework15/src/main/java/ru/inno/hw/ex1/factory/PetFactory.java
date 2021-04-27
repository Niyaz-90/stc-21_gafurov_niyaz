package ru.inno.hw.ex1.factory;

import ru.inno.hw.ex1.model.Bird;
import ru.inno.hw.ex1.model.Cat;
import ru.inno.hw.ex1.model.Dog;
import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.model.PetType;

public class PetFactory {
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
