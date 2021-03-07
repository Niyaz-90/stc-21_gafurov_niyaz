package ru.inno.hw.ex3.models;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Person {
    public final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final String numbersAsString = "0123456789";
    public String name;
    public Sex sex;
    public int age;
    private Random random = new Random();

    public Person() {
        this.sex = new Sex();
//        this.random = new Random();
        this.name = nameGenerator();
        this.age = ageGenerator();
    }

    private String nameGenerator(){
        char[] letters = alphabet.toCharArray();
        StringBuilder personName = new StringBuilder();
        int count = 0;
        while (count < 4){
            personName.append(letters[random.nextInt(letters.length)]);
            count++;
        }
        return String.valueOf(personName);


    }

    private int ageGenerator(){
        char[] numbers = numbersAsString.toCharArray();
        StringBuilder personAge = new StringBuilder();
        int count = 0;
        while (count < 2){
            personAge.append(numbers[random.nextInt(numbers.length)]);
            count++;
        }
        return Integer.parseInt(String.valueOf(personAge));
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

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex.sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




    public static Comparator<Person> sexComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.sex.sex.compareTo(o1.sex.sex);
        }
    };
    public static Comparator<Person> ageComparator = Comparator.comparing(o -> o.age);
    public static Comparator<Person> nameComparator = Comparator.comparing(o -> o.name);


    public static Comparator<Person> uniqueComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            int value1 = o2.getSex().compareTo(o1.getSex());
            if (value1 == 0){
                int value2 = o2.getAge() - o1.getAge();
                if (value2 == 0){
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return value2;
                }

            } return value1;

        }
    };

//    @Override
//    public int compareTo(Person o) {
//
//    }
}
