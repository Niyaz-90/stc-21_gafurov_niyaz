package ru.inno.hw.ex3;

import ru.inno.hw.ex3.models.Person;
import ru.inno.hw.ex3.service.Service;
import ru.inno.hw.ex3.service.ServiceImpl;

import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[10000];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person();
        }
        Service service = new ServiceImpl(persons);
        System.out.println("stream sort result");
        long streamSortStart = System.currentTimeMillis();
        service.beginStreamSort();
        System.out.println("StreamSort end in " + (System.currentTimeMillis() - streamSortStart) +  " ms");
        System.out.println("\n\n\nbubble sort result");
        long quickSortStart = System.currentTimeMillis();
        service.beginQuickSort();
        System.out.println("BubbleSort end in " + (System.currentTimeMillis() - quickSortStart) + " ms");
    }
}
