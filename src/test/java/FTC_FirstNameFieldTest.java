//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class FTC_FirstNameFieldTest {

    private WebDriver driver;
    private String first_name;

    public FTC_FirstNameFieldTest(String first_name){
        this.first_name = first_name;

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
    public static Collection first_names() {
        return Arrays.asList(
                "K",
                "Lorem ipsum dolor sit amett cons"
        );
    }

    @Test
    public void firstNameFieldVerifyBoundaryLengthTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstName(first_name);
        registerPage.clickContinueExpectingFailure();

        RegisterPage updatedRegisterPage = new RegisterPage(driver);

        assertThrows(NoSuchElementException.class, () -> {
            updatedRegisterPage.getError(updatedRegisterPage.getFirstName());
        });
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
