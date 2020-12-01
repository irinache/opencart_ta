package register;

import drivers.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.NoSuchElementException;
import pages.RegisterPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)
public class FTC_CorrectBoundaryLengthLastNameFieldTest {
    private DriverManager driverManager;
    private String lastName;

    public FTC_CorrectBoundaryLengthLastNameFieldTest(String lastName) {
        this.lastName = lastName;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_register");
    }

    @Parameterized.Parameters
    public static Collection lastNames() {
        return Arrays.asList(
                "M",
                "Lorem ipsum dolor sit amett cons"
        );
    }

    @Test
    public void lastNameFieldVerifyBoundaryLengthTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setLastName(lastName);
        registerPage.clickContinueExpectingFailure();

        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());

        assertThrows(NoSuchElementException.class, () -> {
            updatedRegisterPage.getErrorText(updatedRegisterPage.getLastName());
        });
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
