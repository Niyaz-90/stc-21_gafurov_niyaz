package ru.inno.hw10.task1;

import java.io.*;

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File filePath = new File(name + ".class");
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

            byte[] content = new byte[(int) filePath.length()];
            bis.read(content);

            final Class<?> myClass = defineClass(name, content, 0, content.length);

            return myClass;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
