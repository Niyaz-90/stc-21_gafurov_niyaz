package ru.inno.hw.ex3.service;

import ru.inno.hw.ex3.models.Person;
import ru.inno.hw.ex3.methods.QuickSortImpl;
import ru.inno.hw.ex3.methods.StreamSortImpl;

public class ServiceImpl implements Service {
    private StreamSortImpl streamSort;
    private QuickSortImpl quickSort;
    private final Person[] people;

    public ServiceImpl(Person[] people) {
        this.people = people;
        this.streamSort = new StreamSortImpl();
        this.quickSort = new QuickSortImpl(people);
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
