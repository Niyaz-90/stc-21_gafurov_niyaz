package ru.inno.hw.ex1.archive;

import com.sun.istack.internal.Nullable;
import ru.inno.hw.ex1.model.Person;
import ru.inno.hw.ex1.model.Pet;

import java.util.Set;
import java.util.TreeSet;

public class ArchieveTreeSet<K extends Pet> {
    private Set<K> treeSetArchive;

    public ArchieveTreeSet() {
        this.treeSetArchive = new TreeSet<>(Pet.comparator);
    }

    public boolean addPet(K key) {
        return treeSetArchive.add(key);
    }

    public Pet findByNickName(String nickName) {
        for (Pet pet : treeSetArchive) {
            if (pet.getNickname().equals(nickName)) {
                return pet;
            }
        }
        System.out.println("cannot find pet with name : " + nickName);
        return null;
    }

    public void modifyById(int id, @Nullable String nickname, @Nullable Person person, @Nullable int weight) {
        for (Pet pet :
                treeSetArchive) {
            if (pet.getPetId() == id){
                if (nickname != null){
                    pet.setNickname(nickname);
                }
                 if (person != null){
                     pet.setPerson(person);
                 }
                 if (weight != -1){
                     pet.setWeight(weight);
                 }
            }
        }
    }

    public void printAllSorted() {

        for (Pet pet :
                treeSetArchive) {
            pet.toString();
        }
    }
}
