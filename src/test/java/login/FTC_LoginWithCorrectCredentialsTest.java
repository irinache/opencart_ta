package login;

import drivers.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FTC_LoginWithCorrectCredentialsTest {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager("opera");
        driverManager.loadPage("site_login");
    }

    @Test
    public void getLoginPageTest() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.setEmail("kate_m@gmail.com");
        loginPage.setPassword("11111");

        Page actual = loginPage.clickLogin();

        Page expected = new ProfilePage(driverManager.getDriver());

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
