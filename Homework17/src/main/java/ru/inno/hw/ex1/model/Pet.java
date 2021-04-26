package ru.inno.hw.ex1.model;

import ru.inno.hw.ex1.chain_parts.Handler;

public abstract class Pet extends Handler implements Comparable<Pet> {

    private PetType petType;
    private static int id = 1;
    private int petId;
    private String nickname;
    private Person person;
    private int weight;

    public Pet(PetType petType,  String nickname, Person person, int weight) {
        this.petType = petType;
        this.nickname = nickname;
        this.person = person;
        this.weight = weight;
    }

    public Pet() {
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public int getPetId() {
        return petId;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Pet o) {
        int value1 = this.getPerson().getName().compareTo(o.getPerson().getName());
        if (value1 == 0) {
                int value2 = this.getNickname().compareTo(o.getNickname());
                if (value2 == 0) {
                    return this.getWeight() - o.getWeight();
                } else {
                    return value2;
                }
        } else {
            return value1;
        }
    }

    @Override
    public String toString() {
        return "Pet{" + " person=" + person.toString() + " " + petType.toString() +
                " , nickname= '" + nickname + ", weight= " + weight +
                '}';
    }
}
