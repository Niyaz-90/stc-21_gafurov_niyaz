package ru.inno.hw.ex1;

import jdk.internal.org.objectweb.asm.Handle;
import ru.inno.hw.ex1.archive.Archive;
import ru.inno.hw.ex1.archive.ArchiveMapImpl;
import ru.inno.hw.ex1.chain_parts.Handler;
import ru.inno.hw.ex1.chain_parts.PetInfo;
import ru.inno.hw.ex1.model.*;

/*
Паттерн - Команда
 */
public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Иван", 65, Sex.MALE);
        Person marina = new Person("Марина", 35, Sex.FEMALE);
        Person mariya = new Person("Мария", 23, Sex.FEMALE);
        Person roma = new Person("Роман", 34, Sex.MALE);

        Handler dogHandler = new Dog();
        Handler catHandler = new Cat();
        Handler birdHandler = new Bird();

        PetInfo pet1 = new PetInfo(PetType.Dog, "Тузик", ivan, 12);
        PetInfo pet2 = new PetInfo(PetType.Dog, "Белка", roma, 8);
        PetInfo pet3 = new PetInfo(PetType.Cat, "Пончик", marina, 16);
        PetInfo pet4 = new PetInfo(PetType.Dog, "Стрелка", roma, 7);
        PetInfo pet5 = new PetInfo(PetType.Cat, "Барсик", mariya, 5);
        PetInfo pet6 = new PetInfo(PetType.Bird, "Кеша", marina, 1);
        PetInfo pet7 = new PetInfo(PetType.Dog, "Рекс", ivan, 9);
        PetInfo pet8 = new PetInfo(PetType.Cat, "Мурзик", marina, 3);
        PetInfo pet9 = new PetInfo(PetType.Cat, "Мурзик", roma, 6);
        PetInfo pet10 = new PetInfo(PetType.Dog, "Алабай", marina, 5555);

        dogHandler.setSuccessor(catHandler);
        catHandler.setSuccessor(birdHandler);

        Pet tuzik1 = dogHandler.createPetByPetInfo(pet1);
        Pet belka2 = dogHandler.createPetByPetInfo(pet2);
        Pet ponchik3 = dogHandler.createPetByPetInfo(pet3);
        Pet strelka4 = dogHandler.createPetByPetInfo(pet4);
        Pet barsik5 = dogHandler.createPetByPetInfo(pet5);
        Pet kesha6 = dogHandler.createPetByPetInfo(pet6);
        Pet reks7 = dogHandler.createPetByPetInfo(pet7);
        Pet murzik8 = dogHandler.createPetByPetInfo(pet8);
        Pet murzik9 = dogHandler.createPetByPetInfo(pet9);
        Pet customPet = dogHandler.createPetByPetInfo(pet10);

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
    }

}
