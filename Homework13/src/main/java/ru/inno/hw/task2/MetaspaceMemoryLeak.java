package ru.inno.hw.task2;

import java.util.ArrayList;
import java.util.List;

public class MetaspaceMemoryLeak {
    public static void main(String[] args) {
        List<Class> classes = new ArrayList<>();
        while (true){
            CustomClassLoader loader = new CustomClassLoader();
            try {
                classes.add(loader.loadClass("TestClass"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
