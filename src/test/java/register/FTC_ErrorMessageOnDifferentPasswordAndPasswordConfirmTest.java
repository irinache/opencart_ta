package register;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import pages.RegisterPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class FTC_ErrorMessageOnDifferentPasswordAndPasswordConfirmTest {
    private WebDriver driver;
    private String password;
    private String passwordConfirm;

    public FTC_ErrorMessageOnDifferentPasswordAndPasswordConfirmTest(String password, String passwordConfirm) {
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

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

    @Parameterized.Parameters
    public static Collection passwords() {
        return Arrays.asList(new Object[][]{
                {"1234", "44444"},
                {"4321", "123451"}
        } );
    }

    @Test
    public void errorOnDifferentPasswordAndPasswordConfirmTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setPassword(password);
        registerPage.setPasswordConfirm(passwordConfirm);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driver);

        String expected = "Password confirmation does not match password!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getPasswordConfirm());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
