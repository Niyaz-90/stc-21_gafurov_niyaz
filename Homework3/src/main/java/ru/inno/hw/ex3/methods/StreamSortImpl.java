package ru.inno.hw.ex3.methods;

import ru.inno.hw.ex3.models.Person;

import java.util.*;

public class StreamSortImpl implements Sortable {
    private Person[] people;


    public StreamSortImpl() {
    }

    public void setPeople(Person[] people) {

        this.people = people;
    }

    public void sort() {

        long streamSortStart = System.currentTimeMillis();
        Arrays.sort(people, Person::compareTo);
        long streamSortFinish = System.currentTimeMillis();
        for (Person person : people) {
            System.out.println("name: " + person.getName() + " sex: " + person.getSex()
                    + " age: " + person.getAge());
        }
        System.out.println("StreamSort end in " + (streamSortFinish - streamSortStart) + " ms");
    }


}
