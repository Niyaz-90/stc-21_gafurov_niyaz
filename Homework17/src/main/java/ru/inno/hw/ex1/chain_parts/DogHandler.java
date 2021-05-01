package ru.inno.hw.ex1.chain_parts;

import ru.inno.hw.ex1.Main;
import ru.inno.hw.ex1.model.Dog;
import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.model.PetType;

public class DogHandler extends Handler {
    @Override
    public Pet createAndAddToList(PetType petType, String nickname, Person person, int weight) {
        if (petType == PetType.Dog) {
            Dog dog = new Dog(petType, nickname, person, weight);
            Main.dogList.add(dog);
            return dog;
        } else {
            return getSuccessor().createAndAddToList(petType, nickname, person, weight);
        }
    }

}
