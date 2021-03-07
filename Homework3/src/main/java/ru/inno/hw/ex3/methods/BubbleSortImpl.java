package ru.inno.hw.ex3.methods;

import ru.inno.hw.ex3.models.Person;

public class BubbleSortImpl implements Sortable {
    private final Person[] people;

    public BubbleSortImpl(Person[] people) {
        this.people = people;
    }

    @Override
    public String toString() {
        for (int i = 0; i < people.length; i++) {
            System.out.println("name: " + people[i].getName()
            + " sex: " + people[i].getSex()
            + " age: " + people[i].getAge());
        }
        return "that's all";
    }

    public void sort(Person[] people){
        for (int i = 0; i < people.length; i++) {
            for (int j = people.length - 1;  j > 0; j--) {
                int value1 = people[j].getSex().compareTo(people[j - 1].getSex());
                if (value1 == 0){
                    int value2 = people[j].getAge() - people[j - 1].getAge();
                    if (value2 == 0){
                        int value3 = people[j].getName().compareTo(people[j - 1].getName());
                        if (value3 > 0){
                            swap(j, j - 1);
                        }
                    } else if (value2 > 0) {
                        swap(j, j - 1);

                    }
                } else  if (value1 > 0) {
                    swap(j , j - 1);
                }
            }
        }
    }

    private void swap(int p1, int p2){
        Person tmp = people[p1];
        people[p1] = people[p2];
        people[p2] = tmp;
    }

}
