package ru.inno.hw.ex2;


import java.util.LinkedList;
import java.util.List;

public class ObjBox {
    private List<Object> objectsList;

    public ObjBox(LinkedList<Object> objectsList) {
        this.objectsList = objectsList;
    }

    //Добавление объекта
    public boolean addObject(Object object) {

         objectsList.add(object);
        return true;
    }

    //Удаление объекта
    public boolean deleteObject(Object object) {
        boolean isDeleted = objectsList.remove(object);
        if (isDeleted) {
            return true;
        } else {
            System.out.println("Element not found");
            return false;
        }
    }

    // Печать всех элементов
    public void dump() {
        for (Object o : objectsList) {
            System.out.println(o);
        }
    }
}