package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static FileInputStream inputStream;
    static Properties properties;

    static {
        String path = "C:/Users/abakt/IdeaProjects/JavaRecap/src/test/resources/configurations/Configuration.properties";

        try {

            inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Path properties file is invalid");
        } catch (IOException e) {
            System.out.println("Failed to load the properties file");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("Exception occured while closing input objects");
            }
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
