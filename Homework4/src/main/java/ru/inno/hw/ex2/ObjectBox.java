package ru.inno.hw.ex2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ObjectBox {
    private LinkedList<Object> objectsList;

    public ObjectBox(LinkedList<Object> objectsList) {
        this.objectsList = objectsList;
    }

    public boolean addObject(Object object){

        if (object.getClass().getSimpleName().equals("Object")){
            return objectsList.add(object);
        } else {
            return false;
        }
    }

    public boolean deleteObject(Object object){
        boolean isDeleted = objectsList.remove(object);
        if (isDeleted){
            return  true;
        } else {
            System.out.println("Element not found");
            return false;
        }
    }

    public void dump(){
        for (Object o : objectsList) {
            System.out.println(o);
        }
    }
}
