package ru.inno.hw.ex1.chain_parts;

import ru.inno.hw.ex1.Main;
import ru.inno.hw.ex1.model.Bird;
import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.model.PetType;

public class BirdHandler extends Handler {
    @Override
    public Pet createAndAddToList(PetType petType, String nickname, Person person, int weight) {
        if (petType == PetType.Bird) {
            Bird bird = new Bird(petType, nickname, person, weight);
            Main.birdList.add(bird);
            return bird;
        } else {
            return null;
        }
    }
}
