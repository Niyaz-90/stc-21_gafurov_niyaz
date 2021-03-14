package ru.inno.hw.ex3;

import java.util.Arrays;
import java.util.LinkedList;

public class ObjectBox<T> {
    public LinkedList<T> getObjectsList() {
        return objectsList;
    }

    private LinkedList<T> objectsList;


    public ObjectBox(LinkedList<T> numberLinkedList) {
        this.objectsList = numberLinkedList;
    }

    /*Добавление нового элемента в список. Входной параметр - объект класса Object(для выполнения
     условия задачи), хотя если брать на вход объект класса Т, то происходит ошибка компиляции,
     т.к. класс параметризован*/
    public boolean addElement(Object object) {

        try {
            //попытка приведения к нужному типу
            T number = (T) object;
            if (number.getClass().getSimpleName().equals("Object")){
                throw new ClassCastException();
            } else {
                return objectsList.add(number);
            }
        } catch (ClassCastException e){
            System.out.println(e + "Cannot add Object entity to Number container");
            return false;
        }
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
