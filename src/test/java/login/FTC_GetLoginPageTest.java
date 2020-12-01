package login;

import drivers.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Page;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FTC_GetLoginPageTest {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_home");
    }

    @Test
    public void getLoginPageTest() {
        HomePage homePage = new HomePage(driverManager.getDriver());
        homePage.clickMyAccount();
        Page actual = homePage.clickLogin();
        Page expected = new LoginPage(driverManager.getDriver());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
