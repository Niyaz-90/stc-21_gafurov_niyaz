package ru.inno.hw.ex1;

import ru.inno.hw.ex1.archive.Archive;
import ru.inno.hw.ex1.archive.ArchiveMapImpl;
import ru.inno.hw.ex1.factory.PetFactory;
import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.model.PetType;
import ru.inno.hw.ex1.model.Sex;

/*
 Применён паттерн Factory. Его задача - создавать новые объекты с параметрами
 в метод Pet.create(petType, nickname, person, weight).
 Класс объекта определяется параметром petType.
       */
public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Иван", 65, Sex.MALE);
        Person marina = new Person("Марина", 35, Sex.FEMALE);
        Person mariya = new Person("Мария", 23, Sex.FEMALE);
        Person roma = new Person("Роман", 34, Sex.MALE);
        Pet tuzik1 = PetFactory.create(PetType.Dog,"Тузик", ivan, 12);
        Pet belka2 = PetFactory.create(PetType.Dog,"Белка", roma, 8);
        Pet ponchik3 = PetFactory.create(PetType.Cat ,"Пончик", marina, 16);
        Pet strelka4 = PetFactory.create(PetType.Dog,"Стрелка", roma, 7);
        Pet barsik5 = PetFactory.create(PetType.Cat,"Барсик", mariya, 5);
        Pet kesha6 = PetFactory.create(PetType.Bird, "Кеша", marina, 1);
        Pet reks7 = PetFactory.create(PetType.Dog,"Рекс", ivan, 9);
        Pet murzik8 = PetFactory.create(PetType.Cat,"Мурзик", marina, 3);
        Pet murzik9 = PetFactory.create(PetType.Cat,"Мурзик", roma, 6);
        Pet customPet = PetFactory.create(PetType.Dog,"Алабай");
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
