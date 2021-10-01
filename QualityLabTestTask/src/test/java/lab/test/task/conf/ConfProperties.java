package lab.test.task.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static FileInputStream fos;
    private static Properties PROPERTY;
    static {
        try {
            fos = new FileInputStream("src/test/resources/conf.properties");
            PROPERTY = new Properties();
            PROPERTY.load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String property){
        return PROPERTY.getProperty(property);
    }
}
