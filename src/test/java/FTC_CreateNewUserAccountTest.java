import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FTC_CreateNewUserAccountTest {
    WebDriver driver;

    @Before
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
    public void createNewAccountTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstName("Kate");
        registerPage.setLastName("Mikelson");
        registerPage.setEmail("kate2353@gmail.com");
        registerPage.setTelephone("+380666600941");
        registerPage.setPassword("12345");
        registerPage.setPasswordConfirm("12345");
        registerPage.setSubscribeRadioButton(true);
        registerPage.clickPrivacyPolicy();

        Page actual = registerPage.clickContinue();

        Page expected = new SuccessfulRegistrationPage(driver);

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        SuccessfulRegistrationPage srp = new SuccessfulRegistrationPage(driver);
        srp.logout();
        //delete user using admin?
        driver.close();
    }
}
