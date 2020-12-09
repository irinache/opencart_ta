package login;

import drivers.DriverManager;
import drivers.SitePaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Page;

import static org.junit.Assert.assertEquals;

public class FTC_GetLoginPageTest {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.home);
    }

    @Test
    public void getLoginPageTest() {
        HomePage homePage = new HomePage(driverManager.getDriver());
        homePage.clickMyAccount();
        String actual = homePage.getHeader().clickLogin().getPageTitle();
        String expected = new LoginPage(driverManager.getDriver()).getPageTitle();

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
