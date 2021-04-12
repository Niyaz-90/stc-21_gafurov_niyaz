package ru.inno.hw.task2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {


        try {
            File file = new File(name + ".class");
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] content = new byte[(int) file.length()];
            bis.read(content);

            final Class<?> clazz = defineClass(name, content, 0, content.length);

            return clazz;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
