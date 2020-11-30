import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        FileInputStream fis;
        Properties property = new Properties();
        OperaOptions options = new OperaOptions();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);


            String opera_driver_path = property.getProperty("opera_driver_path");
            String opera_binary_path = property.getProperty("opera_binary_path");
            String site = property.getProperty("site");

            options.setBinary(opera_binary_path);
            System.setProperty("webdriver.opera.driver", opera_driver_path);

            WebDriver driver = new OperaDriver(options);

            driver.get(site);

        } catch (IOException e) {
            System.err.println("File not found.");
        }
    }
}
