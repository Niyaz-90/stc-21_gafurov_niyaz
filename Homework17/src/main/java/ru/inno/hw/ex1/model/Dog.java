package ru.inno.hw.ex1.model;

import ru.inno.hw.ex1.chain_parts.PetInfo;

public class Dog extends Pet{
    public Dog(PetType petType, String nickname, Person person, int weight) {
        super(petType, nickname, person, weight);
    }

    public Dog() {
    }

    @Override
    public Pet createPetByPetInfo(PetInfo petInfo) {
        if (petInfo.getPetType() == PetType.Dog){
            return new Dog(petInfo.getPetType(), petInfo.getNickname(), petInfo.getPerson(), petInfo.getWeight());
        } else {
            getSuccessor().createPetByPetInfo(petInfo);
            return null;
        }
    }

}
