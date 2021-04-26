package ru.inno.hw.ex1.model;

import ru.inno.hw.ex1.chain_parts.PetInfo;

public class Cat extends Pet{
    public Cat(PetType petType, String nickname, Person person, int weight) {
        super(petType, nickname, person, weight);
    }

    public Cat() {
    }

    @Override
    public Pet createPetByPetInfo(PetInfo petInfo) {
        if (petInfo.getPetType() == PetType.Cat){
            return new Cat(petInfo.getPetType(), petInfo.getNickname(), petInfo.getPerson(), petInfo.getWeight());
        } else {
            getSuccessor().createPetByPetInfo(petInfo);
        }
        return null;
    }

}
