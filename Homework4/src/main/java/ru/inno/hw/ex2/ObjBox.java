package ru.inno.hw.ex2;


import java.util.LinkedList;

public class ObjBox {
    private LinkedList<Object> objectsList;

    public ObjBox(LinkedList<Object> objectsList) {
        this.objectsList = objectsList;
    }

    //Добавление объекта
    public boolean addObject(Object object) {

        if (object.getClass().getSimpleName().equals("Object")) {
            return objectsList.add(object);
        } else {
            return false;
        }
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