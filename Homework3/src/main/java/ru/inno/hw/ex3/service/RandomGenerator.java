package ru.inno.hw.ex3.service;


import ru.inno.hw.ex3.models.Sex;

import java.util.Random;

public class RandomGenerator {

    private Random random = new Random();
    private final Sex[] sexArray;

    public RandomGenerator() {
        this.sexArray = Sex.values();
    }

    public String nameGenerator() {
        StringBuilder personName = new StringBuilder();
        int count = 0;
        while (count < 4) {
            int randomNumber = random.nextInt(26) + 65;
            personName.append((char) randomNumber);
            count++;
        }
        return String.valueOf(personName);
    }

    public int ageGenerator() {
        return random.nextInt(99) + 1;
    }

    public String sexGenerator() {
        return sexArray[random.nextInt(2)].toString();
    }


}
