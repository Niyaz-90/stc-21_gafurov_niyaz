package ru.inno.hw.ex1.model;

public abstract class Pet implements Comparable<Pet> {
    private static int id = 1;
    private int petId;
    private PetType petType;
    private String nickname;
    private Person person;
    private int weight;

    public Pet(PetType petType, String nickname, Person person, int weight) {
        this.petId = id++;
        this.petType = petType;
        this.nickname = nickname;
        this.person = person;
        this.weight = weight;
    }

    public Pet(PetType petType, String nickname) {
        this.petId = id++;
        this.petType = petType;
        this.nickname = nickname;
        this.person = new Person("НЕ УКАЗАН", -1, Sex.NOT_STATED);
        this.weight = -1;
    }

    public String getPetType() {
        return petType.toString();
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
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
            int value2 = this.getPetType().compareTo(o.getPetType());
            if (value2 == 0) {
                int value3 = this.getNickname().compareTo(o.getNickname());
                if (value3 == 0) {
                    return this.getWeight() - o.getWeight();
                } else {
                    return value3;
                }
            }
            return value2;
        } else {
            return value1;
        }
    }

    @Override
    public String toString() {
        return "Pet{" + " person=" + person.toString() + " , type= " + petType +
                ", nickname= '" + nickname + '\'' +
                ", weight= " + weight +
                '}';
    }

}
