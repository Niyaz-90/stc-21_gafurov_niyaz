package ru.inno.hw.ex3;


/*Задание 3. Доработать классы MathBox и ObjectBox таким образом:
  - чтобы MathBox был наследником ObjectBox.Необходимо сделать такую связь, правильно распределить
   поля и методы. Функциональность в целом должна сохраниться.
  - При попытке положить Object в MathBox должно создаваться исключение.
 */

public class Main {
    public static void main(String[] args) {
        //Исходные данные
        Number[] numbers = {3, 94.4, 56F, 34L};
        MathBox<Number> mathBox1 = new MathBox<>(numbers);

        mathBox1.addElement("p");
        mathBox1.addElement(5L);
        mathBox1.addElement(9.0);
        mathBox1.addElement(5.8);
        mathBox1.addElement('c');
        //Проверка корректной работы методов
        System.out.println(mathBox1.summator());
        mathBox1.splitter(3);
        mathBox1.dump();
        System.out.println(" id = " + mathBox1.getInstanceId());
        mathBox1.addElement(new Object());
        System.out.println(" sum = " + mathBox1.summator());


    }
}
