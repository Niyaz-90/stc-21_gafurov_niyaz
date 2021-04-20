package ru.inno.hw.ex1;

import ru.inno.hw.ex1.archive.Archive;
import ru.inno.hw.ex1.archive.ArchiveMapImpl;
import ru.inno.hw.ex1.model.*;

/*
Применён паттерн Мост. С его помомощью появилсь возможность создавать
питомцев разделяя их на домашних и не домашних. Классы Dog, Cat и Bird наследуются
от абстрактного класса Pet. Pet соддержит поле интерфейса Domecticated  и принимает его реализацию
на вход. Интерфейс Domesticated импелементируется классами Domestic и NonDomestic.
*/

public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Иван", 65, Sex.MALE);
        Person marina = new Person("Марина", 35, Sex.FEMALE);
        Person mariya = new Person("Мария", 23, Sex.FEMALE);
        Person roma = new Person("Роман", 34, Sex.MALE);
        Pet tuzik1 = new Dog(new NonDomestic(),"Тузик", ivan, 12);
        Pet belka2 = new Dog(new NonDomestic(),"Белка", roma, 8);
        Pet ponchik3 = new Cat(new Domestic() ,"Пончик", marina, 16);
        Pet strelka4 = new Dog(new NonDomestic(),"Стрелка", roma, 7);
        Pet barsik5 = new Cat(new Domestic(),"Барсик", mariya, 5);
        Pet kesha6 = new Bird(new Domestic(), "Кеша", marina, 1);
        Pet reks7 = new Dog(new Domestic(),"Рекс", ivan, 9);
        Pet murzik8 = new Cat(new NonDomestic(),"Мурзик", marina, 3);
        Pet murzik9 = new Cat(new NonDomestic(),"Мурзик", roma, 6);
        Pet customPet = new Dog(new Domestic(),"Алабай", marina, 5555);

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
