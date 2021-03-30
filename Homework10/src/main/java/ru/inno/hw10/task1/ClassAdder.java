package ru.inno.hw10.task1;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassAdder {

    public ClassAdder(String className) {
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);

        try {
        File file = new File("MyClass.java");
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter("MyClass.java"));

        String codeFragment = "System.out.println(\\\"Загружен пользовательский класс\\\");\\n\" +\n" +
                "                    \"        System.out.println(\\\"- - - - - - - -\\\");\\n\" +\n" +
                "                    \"        System.out.println(\\\"Начинаю вычисления\\\");\\n\" +\n" +
                "                    \"        int i = 5;\\n\" +\n" +
                "                    \"        System.out.println(\\\" i = \\\" + i);\\n\" +\n" +
                "                    \"        int a = 10;\\n\" +\n" +
                "                    \"        System.out.println(\\\" i = \\\" + a);\\n\" +\n" +
                "                    \"        System.out.println(\\\"i + a = \\\" + (i + a));";


        String code = "public class MyClass{ \\n public void doWork(){\\n" + codeFragment +
                "\\n}\\n}";

        while (scanner.hasNext()){
            codeFragment = scanner.nextLine();
        }

        writer.write(code);
        writer.flush();

        File root = new File("MyClass.class");
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(root));

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, stream, null, code);

        ClassLoader classLoader = new CustomClassLoader();

        Class<?> myClass = Class.forName("MyClass", true, classLoader);
        Object obj = myClass.newInstance();
        Method method = myClass.getMethod("doWork");
        method.invoke(obj);

        } catch (ClassNotFoundException | IOException e){
            System.out.println("Problems\n");

            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    }
