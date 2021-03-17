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
        MathBox mathBox1 = new MathBox(numbers);

        //Проверка корректной работы методов
        System.out.println(mathBox1.summator());
        mathBox1.splitter(3);
        mathBox1.dump();
        System.out.println(" id = " + mathBox1.getInstanceId());
        mathBox1.deleteElement(3);
        mathBox1.addElement(new Object());
        System.out.println(" sum = " + mathBox1.summator());


    }
}
