package ru.inno.hw.ex3.service;

import ru.inno.hw.ex3.exception.DuplicateException;
import ru.inno.hw.ex3.models.Person;
import ru.inno.hw.ex3.methods.BubbleSortImpl;
import ru.inno.hw.ex3.methods.StreamSortImpl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServiceImpl implements Service {
    private final StreamSortImpl streamSort;
    private BubbleSortImpl bubbleSort;
    private Person[] people;
    private Person[] uniquePeople;

    public ServiceImpl(Person[] people) {
        this.people = people;
        this.streamSort = new StreamSortImpl();
        this.bubbleSort = new BubbleSortImpl();
    }

    public void sortUniqueElements() {
        Set<Person> personSet = new HashSet<>();

        for (Person person : people) {
            boolean isPresent = personSet.add(person);
            if (!isPresent) {
                try {
                    throw new DuplicateException();
                } catch (DuplicateException e) {
                    System.out.println(" This person is already present in this set");
                }
            }
        }
        uniquePeople = new Person[personSet.size()];
        personSet.toArray(uniquePeople);
        this.streamSort.setPeople(uniquePeople);
        this.bubbleSort.setPeople(uniquePeople.clone());


    }

    @Override
    public void beginStreamSort() {
        streamSort.sort();
    }

    @Override
    public void beginBubbleSort() {
        bubbleSort.sort();
    }
}
