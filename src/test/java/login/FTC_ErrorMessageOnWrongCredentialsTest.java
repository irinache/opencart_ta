package login;

import drivers.DriverManager;
import java.util.Arrays;
import java.util.Collection;

import drivers.SitePaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FTC_ErrorMessageOnWrongCredentialsTest {
    private final String email;
    private final String password;
    private DriverManager driverManager;

    public FTC_ErrorMessageOnWrongCredentialsTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.login);
    }

    @Parameters
    public static Collection passwords() {
        return Arrays.asList(new Object[][] {
                {"", ""},
                {"kate@gmail.com", "11111"},
                {"kate_m@gmail.com", "565465"}
        });
    }

    @Test
    public void getErrorMessageOnWrongCredentialsTest() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.getLoginForm().setEmail(email);
        loginPage.getLoginForm().setPassword(password);
        loginPage.getLoginForm().submitForm(driverManager.getDriver());

        LoginPage updatedLoginPage = new LoginPage(driverManager.getDriver());

        String expected = "Warning: No match for E-Mail Address and/or Password.";

        String actual = updatedLoginPage.getAlertText();

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
