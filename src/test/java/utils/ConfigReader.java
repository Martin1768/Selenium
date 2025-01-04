package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    / takes the input of a propertyname and returns its value from
    / config.properites file
     */
    public static String read(String propertyName) {

        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_PATH)) {
            properties.load(fis);
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
