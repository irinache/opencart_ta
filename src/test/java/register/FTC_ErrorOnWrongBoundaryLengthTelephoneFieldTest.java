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
public class FTC_ErrorOnWrongBoundaryLengthTelephoneFieldTest {
    private final String telephone;
    private DriverManager driverManager;

    public FTC_ErrorOnWrongBoundaryLengthTelephoneFieldTest(String telephone) {
        this.telephone = telephone;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.register);
    }

    @Parameters
    public static Collection telephones() {
        return Arrays.asList(
                "94",
                "738475903472590456456787687867873"
                            );
    }

    @Test
    public void errorOnWrongBoundaryLengthTelephoneFieldTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.setTelephone(telephone);
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());
        String expected = "Telephone must be between 3 and 32 characters!";

        String actual = updatedRegisterPage.getErrorText(updatedRegisterPage.getTelephone());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
