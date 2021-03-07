package ru.inno.hw.ex3;

import ru.inno.hw.ex3.models.Person;
import ru.inno.hw.ex3.service.Service;
import ru.inno.hw.ex3.service.ServiceImpl;

public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[20];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person();
        }
        Service service = new ServiceImpl(persons);
        System.out.println("stream sort result");
        service.beginStreamSort();
        System.out.println("\nbubble sort result");
        service.beginQuickSort();

    }
}
