package ru.inno.hw.ex1.model;

public class NonDomestic implements Domesticated {
    @Override
    public String printStatus() {
        return "Not domestic";
    }
}
