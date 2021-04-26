package ru.inno.hw.ex1.model;

import ru.inno.hw.ex1.chain_parts.PetInfo;

public class Bird extends Pet{
    public Bird(PetType petType, String nickname, Person person, int weight) {
        super(petType, nickname, person, weight);
    }

    public Bird() {
    }

    @Override
    public Pet createPetByPetInfo(PetInfo petInfo) {
        if (petInfo.getPetType() == PetType.Bird){
            return new Bird(petInfo.getPetType(), petInfo.getNickname(), petInfo.getPerson(), petInfo.getWeight());
        } else {
            getSuccessor().createPetByPetInfo(petInfo);
        }
        return null;
    }

}
