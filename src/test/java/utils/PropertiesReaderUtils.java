package utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesReaderUtils {

    public static String readProperty(String property) {
        String propertyValue = "Property not found";
        try {
            Properties properties = new Properties();
            Path pathToProperties = Paths.get("src", "test", "resources", "configurations.properties");
            InputStream fileInputStream = Files.newInputStream(Paths.get(pathToProperties.toString()));
            properties.load(fileInputStream);
            propertyValue = properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }
}