package ru.inno.hw.ex3.methods;

import ru.inno.hw.ex3.models.Person;

import java.util.*;

public class StreamSortImpl implements Sortable {
    Set<Person> personList = new HashSet<>();


    public void sort(Person[] people){
        Set<Person> personSet = new HashSet<>();

        for (Person person : people) {
            boolean isPresent = personSet.add(person);
            if (!isPresent){
                try {
                    throw new IllegalStateException();
                } catch (IllegalStateException e){
                    System.out.println(" this element is already present in this set");
                }
            }
        }
        Person[] newPersons = new Person[personSet.size()];
        personSet.toArray(newPersons);
        Arrays.sort(newPersons, Person.uniqueComparator);
//        System.out.println(Arrays.toString(newPersons));
        for (Person person : newPersons) {
            System.out.println("name: " + person.getName() + " sex: " + person.getSex()
            + " age: " + person.getAge());
        }
    }




    public List<Person> sortUniqueElements(Person[] persons){
        List<Person> newPersons = new ArrayList<>();
        for (Person person : persons) {
            boolean isPresent = personList.add(person);
            if (!isPresent){
                throw new IllegalArgumentException("Element is present in this set");
            }
            newPersons.addAll(personList);

        }
        return newPersons;
    }
}
