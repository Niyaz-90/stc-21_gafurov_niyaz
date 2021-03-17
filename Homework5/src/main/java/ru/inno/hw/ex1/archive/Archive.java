package ru.inno.hw.ex1.archive;

import ru.inno.hw.ex1.model.Pet;

public interface Archive<K, V> {
    boolean addPet(K key, V value);
    Pet findByNickName(K nickName);
    Pet modifyById(int id);
    void printAllSorted();
}
