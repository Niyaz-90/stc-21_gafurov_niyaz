package ru.inno.hw.ex1.chain_parts;

import ru.inno.hw.ex1.model.Pet;

public abstract class Handler {
    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public Handler getSuccessor() {
        return successor;
    }

    public abstract Pet createPetByPetInfo(PetInfo petInfo);

}
