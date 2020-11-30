import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FTC_GetResistratioPageTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
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

            this.driver = new OperaDriver(options);
            this.driver.get(site);

        } catch (IOException e) {
            System.err.println("File not found.");
        }
    }

    @Test
    public void getRegistrationPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        Page actual = homePage.clickRegister();
        Page expected = new RegisterPage(driver);

        assertEquals(expected, actual);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}

