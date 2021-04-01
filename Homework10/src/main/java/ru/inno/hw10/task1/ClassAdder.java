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
    private List<String> codeLines;

    public ClassAdder() {
        this.codeLines = new ArrayList<>();
    }

    public void add() {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            File file = new File("MyClass.java");
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter("MyClass.java"));

            while (!"".equals(bufferedReader.readLine())) {
                codeLines.add(bufferedReader.readLine());
            }


            String code = "public class MyClass{ \n public void doWork(){ \n" + insertCodeLines() +
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

        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Problems\n");

            e.printStackTrace();
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private String insertCodeLines() {
        StringBuilder result = new StringBuilder();
        for (String line :
                codeLines) {
            result.append(line);
        }
        return result.toString();
    }

}
