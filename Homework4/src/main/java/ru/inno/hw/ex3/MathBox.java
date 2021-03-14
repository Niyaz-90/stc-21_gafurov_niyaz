package ru.inno.hw.ex3;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

public class MathBox extends ObjectBox<Number> {
    private LinkedList<Number> numberLinkedList;
    private static int id = 0;

    private int instanceId;


    public MathBox(Number[] numbers) {
        super(new LinkedList<Number>(Arrays.asList(numbers)));

        this.numberLinkedList = super.getObjectsList();
        this.instanceId = id;
        id++;
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

        for (int i = 0; i < numberLinkedList.size(); i++) {
            sum += numberLinkedList.get(i).doubleValue();
        }
        return sum;
    }

    public void splitter(int divider) {
        for (int i = 0; i < numberLinkedList.size(); i++) {
            Number result = numberLinkedList.get(i).doubleValue() / divider;
            numberLinkedList.set(i, result);
        }
    }

    public void dump() {
        for (Number number : numberLinkedList) {
            System.out.println(number.toString());
        }
    }

    public void remove(Integer numberForRemove) {

        for (int i = 0; i < numberLinkedList.size(); i++) {
            if (numberLinkedList.get(i).getClass().getSimpleName().equals("Double")
                    & numberLinkedList.get(i).doubleValue() == numberForRemove.doubleValue()
                    | numberLinkedList.get(i).getClass().getSimpleName().equals("Integer")
                    & numberLinkedList.get(i).intValue() == numberForRemove) {
                numberLinkedList.remove(i);
                break;
            }
        }
    }
}
