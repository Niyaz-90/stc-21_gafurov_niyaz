package ru.inno.hw.ex3.box;

import java.util.Objects;

public class MathBox<T extends Number> extends ObjectBox<T> {

    private static int id = 0;

    private int instanceId;


    public MathBox(T[] numbers) {
        super(numbers);
        this.instanceId = id;
        id++;
    }

    @Override
    public void addElement(Object object) {
        try {
            Number number = (Number) object;
            super.addElement(object);
        } catch (ClassCastException e) {
            System.out.println("The object isn't instance of Number");
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
        return Objects.hash(instanceId);
    }


    public double summator() {
        double sum = 0;

        for (int i = 0; i < super.getObjectsList().size(); i++) {
            if (super.getObjectsList().get(i) instanceof Number) {
                Number number = (Number) super.getObjectsList().get(i);
                sum += number.doubleValue();
            }
        }
        return sum;
    }

    public void splitter(int divider) {
        for (int i = 0; i < super.getObjectsList().size(); i++) {
            Number number = null;
            if (super.getObjectsList().get(i) instanceof Number) {
                number = (Number) super.getObjectsList().get(i);
                number = number.doubleValue() / divider;
            }
            super.getObjectsList().set(i, number);
        }
    }

}
