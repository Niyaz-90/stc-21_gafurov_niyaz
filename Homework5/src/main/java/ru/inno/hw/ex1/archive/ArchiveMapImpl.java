package ru.inno.hw.ex1.archive;


import java.util.*;

import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.exception.DuplicateException;

public class ArchiveMapImpl<K , V extends Pet> implements Archive<K, V> {
    private Map<K, V> archiveMap;
    private Pet pet;

    public ArchiveMapImpl() {
        this.archiveMap = new HashMap<>();
    }


    @Override
    public boolean addPet(K key, V pet) {
        if (!archiveMap.containsKey(key)) {

            archiveMap.put(key, pet);
            System.out.println("New pet successfully added");  // посмотреть логгеры
            return true;

        } else {
            try {
                throw new DuplicateException();
            } catch (DuplicateException e) {
                System.out.println(" archive already contains  pet " + pet.getNickname());
                return false;
            }
        }

    }


    @Override
    public Pet findByNickName(String nickName) {

        for (Map.Entry entry : archiveMap.entrySet()) {
            Pet pet = (Pet) entry.getKey();
            if (pet.getNickname().equals(nickName)) {
                return pet;
            }
        }

        System.out.println("Pet with such nickname not found");
        return null;
    }


    @Override
    public Pet modifyById(int id) {  // создавать объект и здесь же (@Nullable = посмотреть) присваивавть значения
        if (archiveMap.containsKey(id)) {
            return archiveMap.get(id);
        } else {
            System.out.println("Incorrect ID, cannot find pet with such ID" + id);  // add id
            return null;
        }
    }

    @Override
    public void printAllSorted() {  // посмотреть другие мапы, лучше поменять



        Pet[] pets = archiveMap.values().toArray(new Pet[archiveMap.values().size()]);

        for (int i = 0; i < pets.length; i++) {
            for (int j = pets.length - 1; j > i; j--) {

                if (pets[j].compareTo(pets[j - 1]) < 0) {
                    swap(pets, j, j - 1);
                }
            }
        }
        for (Pet pet : pets) {
            System.out.println(pet.toString());
        }


    }

    private void swap(Pet[] pets, int i1, int i2) {
        Pet temp = pets[i1];
        pets[i1] = pets[i2];
        pets[i2] = temp;
    }
}
