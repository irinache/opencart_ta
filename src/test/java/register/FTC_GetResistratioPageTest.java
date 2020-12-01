package register;

import drivers.DriverManager;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import pages.HomePage;
import pages.Page;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FTC_GetResistratioPageTest {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_home");
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

