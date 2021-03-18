package ru.inno.hw.ex3.models;

import ru.inno.hw.ex3.service.RandomGenerator;

import java.util.Objects;
import java.util.Random;

public class Person implements Comparable<Person>, Cloneable {
    public String name;
    public Sex sex; // в enam
    public int age;

    public Person() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void generateName() {
        this.name = RandomGenerator.nameGenerator();
    }

    public Sex getSex() {
        return sex;
    }

    public void generateSex() {
        this.sex = RandomGenerator.sexGenerator();
    }

    public int getAge() {
        return age;
    }

    public void generateAge() {
        this.age = RandomGenerator.ageGenerator();
    }


    @Override
    public int compareTo(Person o) {
        int value1 = o.getSex().compareTo(this.getSex());
        if (value1 == 0) {
            int value2 = o.getAge() - this.getAge();
            if (value2 == 0) {
                return this.getName().compareTo(o.getName());
            } else {
                return value2;
            }
        }
        return value1;
    }


}
