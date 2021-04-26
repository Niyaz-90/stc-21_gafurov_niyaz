package ru.inno.hw.ex1.chain_parts;

import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.PetType;

public class PetInfo {
    private PetType petType;
    private String nickname;
    private Person person;
    private int weight;

    public PetInfo(PetType petType, String nickname, Person person, int weight) {
        this.petType = petType;
        this.nickname = nickname;
        this.person = person;
        this.weight = weight;
    }

    public PetType getPetType() {
        return petType;
    }

    public String getNickname() {
        return nickname;
    }

    public Person getPerson() {
        return person;
    }

    public int getWeight() {
        return weight;
    }

}
