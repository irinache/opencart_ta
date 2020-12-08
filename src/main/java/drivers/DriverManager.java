package drivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class DriverManager {
    private WebDriver driver;
    private Properties property;
    private static final Logger logger = LogManager.getLogger();
    private static final String pathToConfig =  "src/main/resources/config.properties";


    public DriverManager() {
        property = new Properties();
    }

    public void configureDriver(String type){
        try (FileInputStream fis = new FileInputStream(pathToConfig)) {
            property.load(fis);

            if ("opera".equals(type)) {
                OperaOptions options = new OperaOptions();
                String driverPath = property.getProperty("opera_driver_path");
                String binaryPath = property.getProperty("opera_binary_path");
                options.setBinary(binaryPath);
                System.setProperty("webdriver.opera.driver", driverPath);
                driver = new OperaDriver(options);
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            } else {
                logger.error("Unknown driver type.");
            }
        } catch (IOException e) {
            logger.error("File not found.");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void loadPage(String url) {
        driver.get(url);
    }

    public void driverClose() {
        driver.close();
    }
}
