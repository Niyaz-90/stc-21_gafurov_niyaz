package ru.inno.hw.ex1.archive;

import java.util.*;

import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.exception.DuplicateException;

public class ArchiveMapImpl<K, V extends Pet> implements Archive<K, V> {
    private HashMap<K, V> archiveMap;//коллекция - мапа или arraylist

    public ArchiveMapImpl() {
        this.archiveMap = new HashMap<>();
    }

    @Override
    public boolean addPet(K key, V pet) {
        if (!archiveMap.containsKey(key)) {

                archiveMap.put(key, pet);
                System.out.println("New pet successfully added");
                return true;

        } else {
            try {
                throw new DuplicateException();
            } catch (DuplicateException e) {
                System.out.println(" archive already contains this nickname");
                return false;
            }
        }

    }


    @Override
    public Pet findByNickName(K nickName) {
        if (archiveMap.containsKey(nickName)){
            return archiveMap.get(nickName);
        }
        System.out.println("Pet with such nickname not found");
        return null;
    }


    // ????????
    @Override
    public Pet modifyById(int id) {
        for (E pet : archiveMap) {
            if (pet.getId()==id){
                return pet;
            }
        }
        System.out.println("Incorrect ID");
        return null;
    }

    @Override
    public void printAllSorted() {

        archiveMap.values().stream().sorted(Pet::compareTo).forEach(System.out::println);

    }
}
