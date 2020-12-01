package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    WebDriver driver;
    Properties property;

    public DriverManager(String type){
        property = new Properties();
        FileInputStream fis;

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            if (type.equals("opera")){
                OperaOptions options = new OperaOptions();
                String driver_path = property.getProperty("opera_driver_path");
                String binary_path = property.getProperty("opera_binary_path");
                options.setBinary(binary_path);
                System.setProperty("webdriver.opera.driver", driver_path);
                driver = new OperaDriver(options);
            } else{
                System.out.println("Unknown driver type.");
            }
        } catch (IOException e) {
            System.err.println("File not found.");
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void loadPage(String url){
        driver.get(property.getProperty(url));
    }

    public void driverClose(){
        driver.close();
    }
}
