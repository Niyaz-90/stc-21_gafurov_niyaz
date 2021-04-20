package ru.inno.hw.ex1.archive;

import ru.inno.hw.ex1.exception.DuplicateException;
import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;

import java.util.HashMap;
import java.util.Map;

public class ArchiveMapImpl<K, V extends Pet> implements Archive<K, V> {
    private Map<K, V> archiveMap;
    private boolean isSorted;

    public ArchiveMapImpl() {
        this.archiveMap = new HashMap<>();
        this.isSorted = false;
    }

    @Override
    public boolean addPet(K key, V pet) {
        if (!archiveMap.containsKey(key)) {
            isSorted = false;
            archiveMap.put(key, pet);
            System.out.println("New pet successfully added");
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
            Pet pet = (Pet) entry.getValue();
            if (pet.getNickname().equals(nickName)) {
                return pet;
            }
        }
        System.out.println("Pet with such nickname not found");
        return null;
    }

    @Override
    public void modifyById(int id, String nickname, Person person, int weight) {
        if (archiveMap.containsKey(id)) {
            Pet pet = archiveMap.get(id);
            if (nickname != null) {
                pet.setNickname(nickname);
            }
            if (person != null) {
                pet.setPerson(person);
            }
            if (weight != -1) {
                pet.setWeight(weight);
            }
        } else {
            System.out.println("Incorrect ID, cannot find pet with such ID" + id);
        }
    }

    @Override
    public void printAll() {
        if (!isSorted) {
           archiveMap.values().stream().sorted(Pet::compareTo).forEach(System.out::println);
            isSorted = true;
        } else {
            archiveMap.values().stream().forEach(System.out::println);
        }
    }
}
