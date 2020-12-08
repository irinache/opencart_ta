package wishlist;

import drivers.DriverManager;
import drivers.SitePaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class FTC_WishListPageUnavailableForUnregisteredUser {
    private DriverManager driverManager;

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.home);
    }

    @Test
    public void getLoginPageIfUserUnregisteredTest() {
        HomePage homePage = new HomePage(driverManager.getDriver());
        String actual = homePage.getHeader().clickWishList().getPageTitle();
        String expected = new LoginPage(driverManager.getDriver()).getPageTitle();

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
