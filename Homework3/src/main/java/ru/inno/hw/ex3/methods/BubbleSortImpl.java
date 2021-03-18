package ru.inno.hw.ex3.methods;

import ru.inno.hw.ex3.models.Person;

public class BubbleSortImpl implements Sortable {
    private Person[] people;


    public void setPeople(Person[] people) {
        this.people = people;
    }


    public void sort() {
        long bubbleSortStart = System.currentTimeMillis();
        for (int i = 0; i < people.length; i++) {
            for (int j = people.length - 1; j > i; j--) {

                if (people[j].compareTo(people[j - 1]) < 0) {
                    swap(j, j - 1);
                }
            }
        }

        toString();
        System.out.println("\nBubbleSort end in " +
                (System.currentTimeMillis() - bubbleSortStart) + " ms");
    }

    private void swap(int p1, int p2) {
        Person tmp = people[p1];
        people[p1] = people[p2];
        people[p2] = tmp;
    }

}