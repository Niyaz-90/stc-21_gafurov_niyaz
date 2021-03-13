package ru.inno.hw.ex1;

import java.util.*;

public class MainMathBox {
    public static void main(String[] args) {
        Number[] numbers1 = {3, 6.8, 1L, 4F, 3.0};
        Number[] numbers2 = {3, 78, 12L, 8, 3.0F};
        Number[] numbers3 = {5L, 3.4F, 1, 67, 3.3};
       MathBox mathBox1 = new MathBox(numbers1);
       MathBox mathBox2 = new MathBox(numbers2);
       MathBox mathBox3 = new MathBox(numbers3);

        System.out.println(mathBox1.summator());
       mathBox2.remove(8);
       mathBox3.splitter(4);
        System.out.println(mathBox1.getInstanceId());
        System.out.println(mathBox2.getInstanceId());
        System.out.println(mathBox3.getInstanceId());

        HashMap<Integer, MathBox> mathBoxMap = new HashMap<>();
        mathBoxMap.put(mathBox1.getInstanceId(), mathBox1);
        mathBoxMap.put(mathBox2.getInstanceId(), mathBox2);
        mathBoxMap.put(mathBox3.getInstanceId(), mathBox3);

        System.out.println(mathBoxMap.size());
        System.out.println(mathBoxMap.toString());
    }
}
