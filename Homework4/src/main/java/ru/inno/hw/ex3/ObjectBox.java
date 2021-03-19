package ru.inno.hw.ex3;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ObjectBox<t> {
    private List<Object> objectsList;

    public ObjectBox(Object[] array) {
        this.objectsList = new LinkedList<>(Arrays.asList(array));
    }

    public List<Object> getObjectsList() {
        return objectsList;
    }



    /*Добавление нового элемента в список. Входной параметр - объект класса Object(для выполнения
     условия задачи), хотя если брать на вход любой другой объект(кроме класса Т), то происходит ошибка компиляции,
     т.к. класс параметризован*/
    public void addElement(Object object) {

        objectsList.add(object);
//        return object;
    }

    public boolean deleteElement(Object object) {
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
        for (Object o : objectsList) {
            System.out.println(o);
        }
    }
}
