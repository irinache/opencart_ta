package drivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class DriverManager {
    WebDriver driver;
    Properties property;

    public DriverManager(String type) {
        property = new Properties();

        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            property.load(fis);

            if ("opera".equals(type)) {
                OperaOptions options = new OperaOptions();
                String driverPath = property.getProperty("opera_driver_path");
                String binaryPath = property.getProperty("opera_binary_path");
                options.setBinary(binaryPath);
                System.setProperty("webdriver.opera.driver", driverPath);
                driver = new OperaDriver(options);
            } else {
                System.out.println("Unknown driver type.");
            }
        } catch (IOException e) {
            System.err.println("File not found.");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void loadPage(String url) {
        driver.get(property.getProperty(url));
    }

    public void driverClose() {
        driver.close();
    }
}
