package login;

import drivers.DriverManager;
import drivers.SitePaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.Page;
import pages.ProfilePage;
import pages.ReceiptPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FTC_LoginWithCorrectCredentialsTest {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.login);
    }

    @Test
    public void loginWithCorrectCredentials() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.getLoginForm().setEmail("kate_m@gmail.com");
        loginPage.getLoginForm().setPassword("11111");

        String actual = loginPage.getLoginForm().submitForm(driverManager.getDriver()).getPageTitle();

        String expected = new ProfilePage(driverManager.getDriver()).getPageTitle();

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
