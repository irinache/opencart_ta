package wishlist;

import drivers.DriverManager;
import drivers.SitePaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.WishListPage;

import static org.junit.Assert.assertEquals;

public class FTC_WishListPageAvailableForLoggedInUserTest {
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

        driverManager.loadPage(SitePaths.home);
    }

    @Test
    public void getWishListPageIfUserLoggedInTest() {
        HomePage homePage = new HomePage(driverManager.getDriver());
        String actual = homePage.getHeader().clickWishList().getPageTitle();
        String expected = new WishListPage(driverManager.getDriver()).getPageTitle();

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        WishListPage wishListPage = new WishListPage(driverManager.getDriver());
        wishListPage.getHeader().clickMyAccountDropdown();
        wishListPage.getHeader().clickLogout();
        driverManager.driverClose();
    }
}
