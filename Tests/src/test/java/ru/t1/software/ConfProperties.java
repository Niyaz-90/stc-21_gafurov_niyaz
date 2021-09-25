package ru.t1.software;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static FileInputStream inputStream;
    private static Properties PROPERTY  ;
    static {
        try {
            inputStream = new FileInputStream("src/test/resources/conf.properties");
            PROPERTY = new Properties();
            PROPERTY.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return PROPERTY.getProperty(key);
    }
}
