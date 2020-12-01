package register;

import drivers.DriverManager;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.NoSuchElementException;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class FTC_CorrectBoundaryLengthPasswordTest {
    private final String password;
    private DriverManager driverManager;

    public FTC_CorrectBoundaryLengthPasswordTest(String password) {
        this.password = password;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameters
    public static Collection passwords() {
        return Arrays.asList(
                "1234",
                "12345123451234512345"
                            );
    }

    @Test
    public void passwordFieldVerifyBoundaryLengthTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setPassword(password);
        registerPage.clickContinueExpectingFailure();

        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());

        assertThrows(NoSuchElementException.class, () -> {
            updatedRegisterPage.getErrorText(updatedRegisterPage.getPassword());
        });
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
