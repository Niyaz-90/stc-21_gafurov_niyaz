package ru.inno.hw.ex1.archive;

import java.util.*;

import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;
import ru.inno.hw.ex1.exception.DuplicateException;

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
        if (!archiveMap.values().stream()
                .anyMatch(pet1 -> nickName.equals(pet1.getNickname()))) {
            System.out.println("Pet with such nickname not found");
            return null;
        } else {
            return archiveMap.values().stream().filter(pet -> nickName.equals(pet.getNickname())).findFirst().get();
        }
    }
    @Override
    public void modifyById(int id, String nickname, Person person, int weight) {
        Pet pet = archiveMap.get(id);
        if (pet != null) {
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

        List<Pet> pets = new ArrayList<>(archiveMap.values());
        if (!isSorted) {
          pets.sort(Pet::compareTo);
            isSorted = true;
        }
        for (Pet pet : pets) {
            System.out.println(pet.toString());
        }

    }
//    private void swap(Pet[] pets, int i1, int i2) {
//        Pet temp = pets[i1];
//        pets[i1] = pets[i2];
//        pets[i2] = temp;
//    }
}
