package register;

import drivers.DriverManager;
import drivers.SitePaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.Page;
import pages.RegisterPage;

import static org.junit.Assert.assertEquals;


public class FTC_GetRegistrationPageTest {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.home);
    }

    @Test
    public void getRegistrationPageTest() {
        HomePage homePage = new HomePage(driverManager.getDriver());
        homePage.clickMyAccount();
        Page actual = homePage.clickRegister();
        Page expected = new RegisterPage(driverManager.getDriver());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}

