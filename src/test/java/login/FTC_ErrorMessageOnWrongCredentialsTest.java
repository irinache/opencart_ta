package login;

import drivers.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class FTC_ErrorMessageOnWrongCredentialsTest {
    private DriverManager driverManager;
    private String email;
    private String password;

    public FTC_ErrorMessageOnWrongCredentialsTest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_login");
    }

    @Parameterized.Parameters
    public static Collection passwords() {
        return Arrays.asList(new Object[][]{
                {"", ""},
                {"kate@gmail.com", "11111"},
                {"kate_m@gmail.com", "565465"}
        });
    }

    @Test
    public void getLoginPageTest() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginExpectingFailure();

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
