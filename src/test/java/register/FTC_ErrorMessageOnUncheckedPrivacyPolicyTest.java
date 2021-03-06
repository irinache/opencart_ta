package register;

import drivers.DriverManager;
import drivers.SitePaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.RegisterPage;

import static org.junit.Assert.assertEquals;

public class FTC_ErrorMessageOnUncheckedPrivacyPolicyTest {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.register);
    }

    @Test
    public void errorOnUncheckedPrivacyPolicyTest() {
        RegisterPage registerPage = new RegisterPage(driverManager.getDriver());
        registerPage.clickContinueExpectingFailure();
        RegisterPage updatedRegisterPage = new RegisterPage(driverManager.getDriver());
        String expected = "Warning: You must agree to the Privacy Policy!";

        String actual = updatedRegisterPage.getAlertText();

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
