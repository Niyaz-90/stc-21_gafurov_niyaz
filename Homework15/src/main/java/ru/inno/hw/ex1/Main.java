package ru.inno.hw.ex1;

import com.sun.xml.internal.bind.v2.runtime.output.Pcdata;
import ru.inno.hw.ex1.archive.Archive;
import ru.inno.hw.ex1.archive.ArchiveMapImpl;
import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.model.Sex;

/*
Разработать программу – картотеку домашних животных. У каждого животного есть
уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя,
возраст, пол), вес.

Реализовать:

     - метод добавления животного в общий список (учесть, что добавление дубликатов
    должно приводить к исключительной ситуации)
     - поиск животного по его кличке (поиск должен быть эффективным)
     - изменение данных животного по его идентификатору
     - вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин,
      кличка животного, вес.
       */
public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Иван", 65, Sex.MALE);
        Person marina = new Person("Марина", 35, Sex.FEMALE);
        Person mariya = new Person("Мария", 23, Sex.FEMALE);
        Person roma = new Person("Роман", 34, Sex.MALE);
        Pet tuzik1 = Pet.create("dog","Тузик", ivan, 12);
        Pet belka2 = Pet.create("dog","Белка", roma, 8);
        Pet ponchik3 = Pet.create("cat" ,"Пончик", marina, 16);
        Pet strelka4 = Pet.create("dog","Стрелка", roma, 7);
        Pet barsik5 = Pet.create("cat","Барсик", mariya, 5);
        Pet kesha6 = Pet.create("bird", "Кеша", marina, 1);
        Pet reks7 = Pet.create("dog","Рекс", ivan, 9);
        Pet murzik8 = Pet.create("cat","Мурзик", marina, 3);
        Pet murzik9 = Pet.create("cat","Мурзик", roma, 6);
        Pet customPet = Pet.create("dog","Алабай", marina, 5555);
        Archive<Integer, Pet> petArchive = new ArchiveMapImpl<>();
        petArchive.addPet(tuzik1.getPetId(), tuzik1);
        petArchive.addPet(belka2.getPetId(), belka2);
        petArchive.addPet(ponchik3.getPetId(), ponchik3);
        petArchive.addPet(strelka4.getPetId(), strelka4);
        petArchive.addPet(barsik5.getPetId(), barsik5);
        petArchive.addPet(kesha6.getPetId(), kesha6);
        petArchive.addPet(reks7.getPetId(), reks7);
        petArchive.addPet(murzik8.getPetId(), murzik8);
        petArchive.addPet(ponchik3.getPetId(), ponchik3);
        petArchive.addPet(murzik9.getPetId(), murzik9);

        petArchive.printAll();
        petArchive.addPet(customPet.getPetId(), customPet);
        System.out.println("---------");
        System.out.println( petArchive.findByNickName("Пончик"));
        petArchive.findByNickName("Арчи");
        petArchive.modifyById(6, null, ivan, 2);
        petArchive.printAll();
    }
}
