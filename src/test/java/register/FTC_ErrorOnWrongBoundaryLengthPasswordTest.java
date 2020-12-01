package register;

import drivers.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.RegisterPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class FTC_ErrorOnWrongBoundaryLengthPasswordTest {
    private DriverManager driverManager;
    private String password;

    public FTC_ErrorOnWrongBoundaryLengthPasswordTest(String password) {
        this.password = password;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameterized.Parameters
    public static Collection passwords() {
        return Arrays.asList(
                "",
                "123451234512345123451"
        );
    }

    @Test
    public void errorOnWrongBoundaryLengthPasswordFieldTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setPassword(password);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());
        String expected = "Password must be between 4 and 20 characters!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getPassword());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
