package ru.inno.hw.ex1.model;

import java.util.Optional;

public class Pet implements Comparable<Pet> {
    private int id;
    private String nickname;
    private Person person;
    private int weight;

    public Pet(int id, String nickname, Person person, int weight) {
        this.id = id;
        this.nickname = nickname;
        this.person = person;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (value1 == 0){
            int value2 = this.getNickname().compareTo(o.getNickname());
            if (value2 == 0){
                int value3 = this.getWeight() - o.getWeight();
                if (value3 > 0){
                    return value3;
                }
            } else if (value2 > 0){
                return value2;
            }
        } else if (value1 > 0){
            return value1;
        }
        return 0;
    }
}
