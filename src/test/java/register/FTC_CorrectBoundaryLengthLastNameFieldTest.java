package register;

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
import org.openqa.selenium.NoSuchElementException;
import pages.RegisterPage;

@RunWith(Parameterized.class)
public class FTC_CorrectBoundaryLengthLastNameFieldTest {
    private final String lastName;
    private DriverManager driverManager;

    public FTC_CorrectBoundaryLengthLastNameFieldTest(String lastName) {
        this.lastName = lastName;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.register);
    }

    @Parameters
    public static Collection<String> lastNames() {
        return Arrays.asList(
                "M",
                "Lorem ipsum dolor sit amett cons"
                            );
    }

    @Test(expected = NoSuchElementException.class)
    public void lastNameFieldVerifyBoundaryLengthTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setLastName(lastName);
        registerPage.clickContinueExpectingFailure();

        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());


        updatedRegisterPage.getErrorText(updatedRegisterPage.getLastName());
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
