package ru.inno.hw.ex3.service;

import ru.inno.hw.ex3.models.Person;
import ru.inno.hw.ex3.methods.BubbleSortImpl;
import ru.inno.hw.ex3.methods.StreamSortImpl;

public class ServiceImpl implements Service {
    private StreamSortImpl streamSort;
    private BubbleSortImpl quickSort;
    private final Person[] people;

    public ServiceImpl(Person[] people) {
        this.people = people;
        this.streamSort = new StreamSortImpl();
        this.quickSort = new BubbleSortImpl(people);
    }

    @Override
    public void beginStreamSort() {
        streamSort.sort(people);
    }

    @Override
    public void beginQuickSort() {

        quickSort.sort(people);
        quickSort.toString();
    }
}
