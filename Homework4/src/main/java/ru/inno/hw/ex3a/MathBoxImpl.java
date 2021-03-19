package ru.inno.hw.ex3a;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

class MathBoxImpl<T extends Number> implements ObjectBox<T> {

    private LinkedList<T> numberLinkedList;

    private static int id = 0;

    private int instanceId;


    public MathBoxImpl(T[] numbers) {
        this.numberLinkedList = new LinkedList<>(Arrays.asList(numbers));
        this.instanceId = id;
        id++;
    }

    @Override
    public boolean addElement(Object object) {
        try {
            //попытка приведения к нужному типу
            T number = (T) object;
            if (number.getClass().getSimpleName().equals("Object")) {
                throw new ClassCastException();
            } else {
                return numberLinkedList.add(number);
            }
        } catch (ClassCastException e) {
            System.out.println(e + " Cannot add Object entity to Number container");
            return false;
        }
    }

    @Override
    public boolean deleteElement(T object) {
        boolean isDeleted = numberLinkedList.remove(object);
        if (isDeleted) {
            System.out.println(true);
            return true;
        } else {
            System.out.println("Element not found");
            return false;
        }
    }

    @Override
    public void dump() {
        for (T o : numberLinkedList) {
            System.out.println(o);
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
        MathBoxImpl<T> mathBox = (MathBoxImpl<T>) o;
        return instanceId == mathBox.instanceId && numberLinkedList.equals(mathBox.numberLinkedList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberLinkedList, instanceId);
    }

    public double summator() {
        double sum = 0;


        for (int i = 0; i < numberLinkedList.size(); i++) {

//            if ()
            sum += numberLinkedList.get(i).doubleValue();
        }
        return sum;
    }

    public void splitter(int divider) {
        for (int i = 0; i < numberLinkedList.size(); i++) {
            Number result = (numberLinkedList.get(i).doubleValue() / divider);
            numberLinkedList.set(i, (T) result);
        }
    }


    public void remove(Integer numberForRemove) {

        for (int i = 0; i < numberLinkedList.size(); i++) {
            if (numberLinkedList.get(i).getClass().getSimpleName().equals("Double")
                    & numberLinkedList.get(i).doubleValue() == numberForRemove.doubleValue()
                    | numberLinkedList.get(i).getClass().getSimpleName().equals("Integer")
                    & numberLinkedList.get(i).intValue() == numberForRemove) {
                numberLinkedList.remove(i);
                System.out.println(numberForRemove + " successfully deleted");
                break;
            }
        }
        System.out.println("Incorrect number");
    }
}
