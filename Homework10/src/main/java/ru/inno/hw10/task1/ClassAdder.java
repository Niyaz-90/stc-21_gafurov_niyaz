package ru.inno.hw10.task1;

import jdk.internal.dynalink.linker.LinkerServices;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassAdder {
    private List<String> codeLines;

    public ClassAdder() {
        this.codeLines = new ArrayList<>();
    }

    public void add() {

        try( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter("MyClass.java"))
        ) {
            File root = new File("MyClass.java");
            root.createNewFile();



            StringBuilder line = new StringBuilder();
            String subLine;
            do {
                subLine = bufferedReader.readLine();
                if (!"".equals(subLine)) {
                    line.append(subLine).append("\n");
                    codeLines.add(line.toString());
                }
            }
            while (!"".equals(subLine));

            String code = "public class MyClass{ \n public void doWork(){ \n" + insertCodeLines() +
                    "\n} \n}";

            writer.write(code);
            writer.flush();

            File compiledFile = new File("MyClass.class");
            compiledFile.createNewFile();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(compiledFile));

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(null, stream, null, root.getPath());
            stream.close();

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
