package ru.inno.hw.ex3.service;


import ru.inno.hw.ex3.models.Sex;

import java.util.Random;

public  class  RandomGenerator {

    private static Random random = new Random();
    private static final Sex[] sexArray = Sex.values();



    public static String nameGenerator() {
        StringBuilder personName = new StringBuilder();
        int count = 0;
        while (count < 4) {
            int randomNumber = random.nextInt(26) + 65;
            personName.append((char) randomNumber);
            count++;
        }
        return String.valueOf(personName);
    }

    public static int ageGenerator() {
        return random.nextInt(99) + 1;
    }

    public static Sex sexGenerator() {
        return sexArray[random.nextInt(2)];
    }


}
