package ru.inno.hw.ex1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class MathBox {
    private static int id = 0;

    public int getInstanceId() {
        return instanceId;
    }

    private int instanceId;
    private LinkedList<Number> numberLinkedList;

    public MathBox(Number[] numbers) {
        this.numberLinkedList = new LinkedList<>(Arrays.asList(numbers));
        this.instanceId = id;
        id++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MathBox.id = id;
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
        return Objects.hash(instanceId, numberLinkedList);
    }

    public double summator() {
        double sum = 0;
        for (Number number : numberLinkedList) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public void splitter(int divider) {
        for (int i = 0; i < numberLinkedList.size(); i++) {
            double result = numberLinkedList.get(i).doubleValue() / divider;
            numberLinkedList.set(i, result);
        }
    }

    public void dump() {
        for (Number number : numberLinkedList) {
            System.out.println(number.doubleValue());
        }
    }

    public void remove(Integer numberForRemove) {

        for (int i = 0; i < numberLinkedList.size(); i++) {
            if (numberLinkedList.get(i).getClass().getSimpleName().equals("Double") & numberLinkedList.get(i).doubleValue() == numberForRemove.doubleValue()
                    | numberLinkedList.get(i).getClass().getSimpleName().equals("Integer") & numberLinkedList.get(i).intValue() == numberForRemove) {
                numberLinkedList.remove(i);
                break;
            }
        }
    }
}
