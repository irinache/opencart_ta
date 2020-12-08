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
import pages.RegisterPage;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FTC_ErrorOnWrongBoundaryLengthLastNameFieldTest {
    private final String lastName;
    private DriverManager driverManager;

    public FTC_ErrorOnWrongBoundaryLengthLastNameFieldTest(String lastName) {
        this.lastName = lastName;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.register);
    }

    @Parameters
    public static Collection lastNames() {
        return Arrays.asList(
                "",
                "Lorem ipsum dolor sit amett consectetur"
                            );
    }

    @Test
    public void errorOnWrongBoundaryLengthLastNameFieldTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setLastName(lastName);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());
        String expected = "Last Name must be between 1 and 32 characters!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getLastName());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
