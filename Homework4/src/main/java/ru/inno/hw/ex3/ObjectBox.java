package ru.inno.hw.ex3;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ObjectBox<T> {
    private List<T> objectsList;

    public ObjectBox(T[] array) {
        this.objectsList = new LinkedList<>(Arrays.asList(array));
    }

    public List<T> getObjectsList() {
        return objectsList;
    }



    /*Добавление нового элемента в список. Входной параметр - объект класса Object(для выполнения
     условия задачи), хотя если брать на вход любой другой объект(кроме класса Т), то происходит ошибка компиляции,
     т.к. класс параметризован*/
    public T addElement(Object object) {

        objectsList.add(object);
        return object;
    }

    public boolean deleteElement(T object) {
        boolean isDeleted = objectsList.remove(object);
        if (isDeleted) {
            System.out.println(true);
            return true;
        } else {
            System.out.println("Element not found");
            return false;
        }
    }

    public void dump() {
        for (T o : objectsList) {
            System.out.println(o);
        }
    }
}
