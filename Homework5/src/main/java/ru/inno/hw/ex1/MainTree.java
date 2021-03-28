package ru.inno.hw.ex1;

import ru.inno.hw.ex1.archive.ArchieveTreeSet;
import ru.inno.hw.ex1.archive.Archive;
import ru.inno.hw.ex1.archive.ArchiveMapImpl;
import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.model.Sex;

public class MainTree {
    public static void main(String[] args) {

        ArchieveTreeSet<Pet> petArchive = new ArchieveTreeSet<>();

        Person ivan = new Person("Иван", 65, Sex.MALE);
        Person marina = new Person("Марина", 35, Sex.FEMALE);
        Person mariya = new Person("Мария", 23, Sex.FEMALE);
        Person roma = new Person("Роман", 34, Sex.MALE);
        Pet tuzik1 = new Pet("Тузик", ivan, 12);
        Pet belka2 = new Pet("Белка", roma, 8);
        Pet ponchik3 = new Pet("Пончик", marina, 16);
        Pet strelka4 = new Pet("Стрелка", roma, 7);
        Pet barsik5 = new Pet("Барсик", mariya, 5);
        Pet kesha6 = new Pet("Кеша", marina, 1);
        Pet reks7 = new Pet("Рекс", ivan, 9);
        Pet murzik8 = new Pet("Мурзик", marina, 3);
        Pet murzik9 = new Pet("Мурзик", roma, 6);

        petArchive.addPet( tuzik1);
        petArchive.addPet( belka2);
        petArchive.addPet( ponchik3);
        petArchive.addPet( strelka4);
        petArchive.addPet( barsik5);
        petArchive.addPet( kesha6);
        petArchive.addPet( reks7);
        petArchive.addPet( murzik8);
        petArchive.addPet( ponchik3);
        petArchive.addPet( murzik9);

        petArchive.findByNickName("Арчи");
        petArchive.findByNickName("Мурзик");
        petArchive.modifyById(3, null, null, 18);
        System.out.println(petArchive.findByNickName("Пончик"));
    }
}
