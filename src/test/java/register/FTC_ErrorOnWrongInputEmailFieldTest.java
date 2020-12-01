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
public class FTC_ErrorOnWrongInputEmailFieldTest {
    private DriverManager driverManager;
    private String email;

    public FTC_ErrorOnWrongInputEmailFieldTest(String email) {
        this.email = email;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameterized.Parameters
    public static Collection emails() {
        return Arrays.asList(
                "kate2343gmail.com",
                "katerina3@gmailcom"
        );
    }

    @Test
    public void errorOnWrongInputEmailFieldTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setEmail(email);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());
        String expected = "E-Mail Address does not appear to be valid!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getEmail());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
