package ru.inno.hw10.task1;

import jdk.internal.dynalink.linker.LinkerServices;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassAdder {
    private List<String>  codeLines;

    public ClassAdder() {
        this.codeLines = new ArrayList<>();
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);

        try {
        File file = new File("MyClass.java");
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter("MyClass.java"));

//        String codeFragment = "System.out.println(\"Загружен пользовательский класс\");\n" +
//            "System.out.println(\"- - - - - - - -\");\n" +
//            "System.out.println(\"Начинаю вычисления\");\n" +
//            "int i = 5;\n" +
//            "System.out.println(\" i = \" + i);\n" +
//            "int a = 10;\n" +
//            "System.out.println(\" i = \" + a);\n" +
//            "System.out.println(\"i + a = \" + (i + a));\n";



            StringBuilder codeFragment = new StringBuilder();
            while (!"".equals(scanner.nextLine())){
                codeLines.add(scanner.nextLine());
            }
//            while (!scanner.nextLine().equals("")){
//                codeFragment.append(scanner.nextLine());
//            }
            String code = "public class MyClass{ \n public void doWork(){\n" + codeFragment +
                    "\n}\n}";

        writer.write(code);
        writer.flush();

        File root = new File("MyClass.class");
        root.createNewFile();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(root));

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, stream, null, file.getPath());

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
