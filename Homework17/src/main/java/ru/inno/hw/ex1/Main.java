package ru.inno.hw.ex1;

import ru.inno.hw.ex1.archive.Archive;
import ru.inno.hw.ex1.archive.ArchiveMapImpl;
import ru.inno.hw.ex1.chain_parts.*;
import ru.inno.hw.ex1.model.*;

import java.util.ArrayList;
import java.util.List;

/*
Паттерн - Команда
 */
public class Main {
    public static List<Dog> dogList = new ArrayList<>();
    public static List<Cat> catList = new ArrayList<>();
    public static List<Bird> birdList = new ArrayList<>();
    public static void main(String[] args) {
        Person ivan = new Person("Иван", 65, Sex.MALE);
        Person marina = new Person("Марина", 35, Sex.FEMALE);
        Person mariya = new Person("Мария", 23, Sex.FEMALE);
        Person roma = new Person("Роман", 34, Sex.MALE);

        Handler dogHandler = new DogHandler();
        Handler catHandler = new CatHandler();
        Handler birdHandler = new BirdHandler();

        dogHandler.setSuccessor(catHandler);
        catHandler.setSuccessor(birdHandler);

        Pet tuzik1 = dogHandler.createAndAddToList(PetType.Dog, "Тузик", ivan, 12);
        Pet belka2 = dogHandler.createAndAddToList(PetType.Dog, "Белка", roma, 8);
        Pet ponchik3 = dogHandler.createAndAddToList(PetType.Cat, "Пончик", marina, 16);
        Pet strelka4 = dogHandler.createAndAddToList(PetType.Dog, "Стрелка", roma, 7);
        Pet barsik5 = dogHandler.createAndAddToList(PetType.Cat, "Барсик", mariya, 5);
        Pet kesha6 = dogHandler.createAndAddToList(PetType.Bird, "Кеша", marina, 1);
        Pet reks7 = dogHandler.createAndAddToList(PetType.Dog, "Рекс", ivan, 9);
        Pet murzik8 = dogHandler.createAndAddToList(PetType.Cat, "Мурзик", marina, 3);
        Pet murzik9 = dogHandler.createAndAddToList(PetType.Cat, "Мурзик", roma, 6);
        Pet customPet = dogHandler.createAndAddToList(PetType.Dog, "Алабай", marina, 5555);

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
        System.out.println(petArchive.findByNickName("Пончик"));
        petArchive.findByNickName("Арчи");
        petArchive.modifyById(6, null, ivan, 2);
        petArchive.printAll();

        System.out.println("--------------------------------");
        dogList.stream().forEach(System.out::println);
        System.out.println("--------------------------------");
        catList.stream().forEach(System.out::println);
        System.out.println("--------------------------------");
        birdList.stream().forEach(System.out::println);

    }

}
