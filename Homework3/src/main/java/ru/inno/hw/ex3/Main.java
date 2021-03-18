package ru.inno.hw.ex3;

import ru.inno.hw.ex3.models.Person;
import ru.inno.hw.ex3.service.Service;
import ru.inno.hw.ex3.service.ServiceImpl;


/*
Исправления:
 - Comparator заменён методом compareTo();
 - логика сравнения в BubbleSortImpl перемещена также в compareTo();
 - генерация случайных имёнб возраста и пола вынесены в отдельный класс RandomGenerator;
 - убрана обёртка над Enam-ом Sex;
 - добавлено исключение DuplicateException;
 */
public class Main {
    public static void main(String[] args) {

        Person[] persons = new Person[1000];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person();
            persons[i].generateName();
            persons[i].generateAge();
            persons[i].generateSex();
        }
        Service service = new ServiceImpl(persons);
        service.sortUniqueElements();
        System.out.println("stream sort result");
        service.beginStreamSort();
        System.out.println("\n\n\nbubble sort result");
        service.beginBubbleSort();

    }
}
