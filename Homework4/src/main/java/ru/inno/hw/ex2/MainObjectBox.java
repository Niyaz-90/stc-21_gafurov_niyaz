package ru.inno.hw.ex2;

import java.util.LinkedList;
import java.util.Objects;

/*Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.

        - У класса должен быть метод addObject, добавляющий объект в коллекцию.
        - У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции
         и при наличии удаляющий его.
        - Должен быть метод dump, выводящий содержимое коллекции в строку.
*/
public class MainObjectBox {
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();

        //исходные данные
        Object o1 = new Object();
        Object o1a = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object o4 = new Object();
        linkedList.add(o1);
        linkedList.add(o1a);
        linkedList.add(o2);
        linkedList.add(o3);
        linkedList.add(o4);

        ObjBox objectBox = new ObjBox(linkedList);

        // Проверка работы методов
        Object obj = new Object();
        String str = " srt";
        int a = 5;
        char character = 'r';
        System.out.println("obj: " + objectBox.addObject(obj));
        System.out.println(objectBox.addObject(str));
        System.out.println(objectBox.addObject(a));
        System.out.println(objectBox.addObject(character));
        System.out.println("-----------");
        objectBox.dump();
        System.out.println("-----------");
        System.out.println("delete object " + o1a + " : " + objectBox.deleteObject(o1a));
        objectBox.dump();


    }
}
