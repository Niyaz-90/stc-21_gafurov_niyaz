package ru.inno.hw.ex3a;




/*Реализация задания 3 с использованием интерфейсов*/

public class MainInterface {
    public static void main(String[] args) {
        //исходные данные
        Number[] numbers = {3, 94.4, 56F, 34L};
        MathBoxImpl<Number> mathBox1 = new MathBoxImpl<>(numbers);

        //проверка корректности работы методов
        System.out.println(mathBox1.summator());
        mathBox1.remove(3);
        mathBox1.splitter(3);
        mathBox1.splitter(32);
        mathBox1.dump();
        System.out.println(" id = " + mathBox1.getInstanceId());
        mathBox1.deleteElement(3);
        mathBox1.addElement(new Object());
        System.out.println(" sum = " + mathBox1.summator());

    }
}
