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
public class FTC_ErrorMessageOnDifferentPasswordAndPasswordConfirmTest {
    private DriverManager driverManager;
    private String password;
    private String passwordConfirm;

    public FTC_ErrorMessageOnDifferentPasswordAndPasswordConfirmTest(String password, String passwordConfirm) {
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameterized.Parameters
    public static Collection passwords() {
        return Arrays.asList(new Object[][]{
                {"1234", "44444"},
                {"4321", "123451"}
        });
    }

    @Test
    public void errorOnDifferentPasswordAndPasswordConfirmTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setPassword(password);
        registerPage.setPasswordConfirm(passwordConfirm);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());

        String expected = "Password confirmation does not match password!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getPasswordConfirm());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
