package ru.inno.hw.ex1;

import java.util.*;

public class MathBox {
    private static int id = 1;

    private final int instanceId;


    private List<Number> numberLinkedList;



    public MathBox(Number[] numbers) {
        Set<Number> numberSet = new HashSet<>(Arrays.asList(numbers));
        this.numberLinkedList = new LinkedList<>(numberSet);
        this.instanceId = id++;
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
        return Objects.hash(instanceId, numberLinkedList);
    }

    // суммирование элементов
    public double summator() {
        double sum = 0;
        for (Number number : numberLinkedList) {
            sum += number.doubleValue();
        }
        return sum;
    }

    //деление всех элементов на делитель
    public void splitter(int divider) {
        for (int i = 0; i < numberLinkedList.size(); i++) {
            double result = numberLinkedList.get(i).doubleValue() / divider;
            numberLinkedList.set(i, result);
        }
    }


    //Удаление
    public void remove(Integer numberForRemove) {

        for (int i = 0; i < numberLinkedList.size(); i++) {
            if (numberLinkedList.get(i) instanceof Number // убрать избыточная строка(проверка)
                    & numberLinkedList.get(i).doubleValue() == numberForRemove.doubleValue()) {
                numberLinkedList.remove(i);
                break;
            }
        }
    }
}
