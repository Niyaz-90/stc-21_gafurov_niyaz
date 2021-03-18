package ru.inno.hw.ex3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

 class MathBox<T extends Number> extends ObjectBox<T> {
     //LinkedList т.к. большинство методов проходят по всем элементам
    private List<T> numberLinkedList;
    private static int id = 0;

    private int instanceId;


    public MathBox(T[] numbers) {
        super(numbers);
        this.numberLinkedList = super.getObjectsList();
        this.instanceId = id;
        id++;
    }

     @Override
     public T addElement(T object) {
        if (super.addElement(object) instanceof Number) {
            return super.addElement(object);
        }
        try {
            throw new UnsupportedClassException();
        } catch (UnsupportedClassException e){
            System.out.println("The instance isn't instance of Number");
            return null;
        }
     }

     public int getInstanceId() {
        return instanceId;
    }


    @Override
    public String toString() {
        return "MathBox " + this.getInstanceId() + " : " + numberLinkedList.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return instanceId == mathBox.instanceId && numberLinkedList.equals(mathBox.numberLinkedList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberLinkedList, instanceId);
    }


    public double summator() {
        double sum = 0;

        for (int i = 0; i < super.getObjectsList().size(); i++) {
            sum += super.getObjectsList().get(i).doubleValue();
        }
        return sum;
    }

    public void splitter(int divider) {
        for (int i = 0; i < super.getObjectsList().size(); i++) {
            Double result = super.getObjectsList().get(i).doubleValue() / divider;
            numberLinkedList.set(i, (T)result);
        }
    }

    public void dump() {
        for (Number number : numberLinkedList) {
            System.out.println(number.toString());
        }
    }

    //Удаление элемента
    public void remove(Integer numberForRemove) {

        for (int i = 0; i < numberLinkedList.size(); i++) {
            if (numberLinkedList.get(i) instanceof Number
                    & numberLinkedList.get(i).doubleValue() == numberForRemove.doubleValue()) {
                numberLinkedList.remove(i);
                break;
            }
        }
    }
}
