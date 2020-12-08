package wishlist;

import drivers.DriverManager;
import drivers.SitePaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import static org.junit.Assert.assertEquals;

public class FTC_ContinueButtonTest {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");

        driverManager.loadPage(SitePaths.login);

        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.getLoginForm().setEmail("kate_m@gmail.com");
        loginPage.getLoginForm().setPassword("11111");
        loginPage.getLoginForm().submitForm(driverManager.getDriver());

        driverManager.loadPage(SitePaths.wishlist);
    }

    @Test
    public void continueButtonTest() {
        WishListPage wishListPage = new WishListPage(driverManager.getDriver());

        String actual = wishListPage.clickContinue().getPageTitle();
        String expected = new ProfilePage(driverManager.getDriver()).getPageTitle();

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        ProfilePage profilePage = new ProfilePage(driverManager.getDriver());
        profilePage.getHeader().clickMyAccountDropdown();
        profilePage.getHeader().clickLogout();
        driverManager.driverClose();
    }
}
