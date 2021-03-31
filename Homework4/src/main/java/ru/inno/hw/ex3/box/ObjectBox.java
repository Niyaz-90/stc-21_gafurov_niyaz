package ru.inno.hw.ex3.box;


import java.util.*;

public class ObjectBox<T> {
    private List<Object> objectsList;

    public ObjectBox(Object[] array) {
        Set<Object> mathset = new HashSet<>(Arrays.asList(array));
        this.objectsList = new LinkedList<>(mathset);
    }

    public List<Object> getObjectsList() {
        return objectsList;
    }


    public void addElement(Object object) {

        objectsList.add(object);
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
