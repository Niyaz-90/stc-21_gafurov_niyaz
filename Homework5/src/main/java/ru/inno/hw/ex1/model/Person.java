package ru.inno.hw.ex1.model;

import java.util.Comparator;

public class Person {
    private String name;
    private int age;
    private Enum sex;

    public Person(String name, int age, Enum sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex.toString();
    }

    @Override
    public String toString() {
        return "{ " +
                "имя = '" + name + '\'' +
                ", возраст = " + age +
                ", sex = " + sex + " " +
                '}';
    }


}
