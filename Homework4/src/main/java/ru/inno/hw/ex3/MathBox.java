package ru.inno.hw.ex3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

 class MathBox<T extends Number> extends ObjectBox<T> {
     //LinkedList т.к. большинство методов проходят по всем элементам
//    private List<T> numberLinkedList;
    private static int id = 0;

    private int instanceId;


    public MathBox(T[] numbers) {
        super(numbers);
//        this.numberLinkedList = super.getObjectsList();
        this.instanceId = id;
        id++;
    }

     @Override
     public void addElement(Object object) {
        try {
            Number number = (Number) object;
            super.addElement(object);
        } catch (ClassCastException e){
            System.out.println("The instance isn't instance of Number");

        }
        if (object instanceof Number) {

        }
        try {
            throw new UnsupportedClassException();
        } catch (UnsupportedClassException e){

        }
     }



     public int getInstanceId() {
        return instanceId;
    }


    @Override
    public String toString() {
        return "MathBox " + this.getInstanceId() + " : " + super.getObjectsList().toString();

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox<T> mathBox = (MathBox<T>) o;
        return instanceId == mathBox.instanceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash( instanceId);
    }


    public double summator() {
        double sum = 0;

        for (int i = 0; i < super.getObjectsList().size(); i++) {
            if (super.getObjectsList().get(i) instanceof Number) {
                Number number = (Number) super.getObjectsList().get(i);
                sum+= number.doubleValue();
            }
        }
        return sum;
    }

    public void splitter(int divider) {
        for (int i = 0; i < super.getObjectsList().size(); i++) {
            Number number = null;
            if (super.getObjectsList().get(i) instanceof Number) {
                number = (Number) super.getObjectsList().get(i);
                number = number.doubleValue()/divider;
            }
            super.getObjectsList().set(i, number);
        }
    }

}
