package ru.inno.hw.ex3a;

public interface ObjectBox<T> {
    boolean addElement(Object object);
    boolean deleteElement(T object);
    void dump();
}
