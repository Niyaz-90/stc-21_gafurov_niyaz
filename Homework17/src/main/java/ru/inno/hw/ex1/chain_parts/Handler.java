package ru.inno.hw.ex1.chain_parts;

import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.model.PetType;

public abstract class Handler {
    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public Handler getSuccessor() {
        return successor;
    }

    public abstract Pet createAndAddToList(PetType petType, String nickname, Person person, int weight);

}
