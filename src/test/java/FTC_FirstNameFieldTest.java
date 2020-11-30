import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FTC_FirstNameFieldTest {
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
            this.driver.get(site + "index.php?route=account/register");

        } catch (IOException e) {
            System.err.println("File not found.");
        }
    }

    @Test
    public void firstNameFieldRightInputTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.typeFirstName("Irina");
        registerPage.submitRegister();

        RegisterPage updatedRegisterPage = new RegisterPage(driver);

        assertThrows(NoSuchElementException.class, () -> {
            updatedRegisterPage.getError(updatedRegisterPage.getFirstName());
        });
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}
