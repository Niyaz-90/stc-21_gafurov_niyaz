package ru.inno.hw.ex3.models;

import java.util.Random;

public class Sex {
    public enum sexEnum {MALE, FEMALE}

    public String sex;

    public Sex() {
        this.sex = randomSexGenerator();
    }

    @Override
    public String toString() {
        return sex;
    }

    public String randomSexGenerator() {
        Random random = new Random();
        int generatedNumber = random.nextInt(2);
//        System.out.println(generatedNumber + Sex.class.getName() + " sexRandomGenerator");
        switch (generatedNumber) {
            case 0:
                sex = String.valueOf(sexEnum.MALE);
                break;
            case 1:
                sex = String.valueOf(sexEnum.FEMALE);
                break;
        }
        return sex;
    }

}
