package ru.inno.hw.ex1.chain_parts;

import ru.inno.hw.ex1.Main;
import ru.inno.hw.ex1.model.Cat;
import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.model.PetType;

public class CatHandler extends Handler {
    @Override
    public Pet createAndAddToList(PetType petType, String nickname, Person person, int weight) {
        if (petType == PetType.Cat) {
            Cat cat = new Cat(petType, nickname, person, weight);
            Main.catList.add(cat);
            return cat;
        } else {
            return getSuccessor().createAndAddToList(petType, nickname, person, weight);
        }
    }

}
