package ru.inno.hw.task2;

import javassist.CannotCompileException;
import javassist.ClassPool;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

public class MetaspaceMemoryLeak {
    public static void main(String[] args) {

        try {
            File text = new File("testClass.txt");
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(text));

            File root = new File("TestClass.java");
            root.createNewFile();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(root));
            byte[] bytes = new byte[(int) text.length()];
            bis.read(bytes, 0, bytes.length);
            stream.write(bytes);
            stream.flush();
            String name = "TestClass";
            File compiledFile = new File(name + ".class");

            compiledFile.createNewFile();

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(compiledFile));

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(bis, bos, null, root.getPath());
            bos.close();

            ClassLoader loader = new CustomClassLoader();
//        loader.f
            int count = 10;
            while (true) {
                Class[] classes = new Class[count];
                for (int i = 0; i < classes.length; i++) {
                    try {
                        Class clas = Class.forName("TestClass", true, loader);
                        System.out.println(clas.getName());
                        classes[i] = clas;

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                count *= 5;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
