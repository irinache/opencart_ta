package wishlist;

import drivers.DriverManager;
import drivers.SitePaths;
import models.ProductRow;
import models.ProductThumb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.ItemPage;
import pages.LoginPage;
import pages.WishListPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FTC_ItemLinkTest {
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
    public void itemLinkTest() {
        HomePage homePage = new HomePage(driverManager.getDriver());

        List<ProductThumb> products = homePage.getProductThumbs();
        String productName = "MacBook";

        for (ProductThumb item : products) {
            if (item.getCaption().equals(productName)) {
                item.clickAddToWishList();
            }
        }

        driverManager.loadPage(SitePaths.wishlist);

        WishListPage wishListPage = new WishListPage(driverManager.getDriver());
        List<ProductRow> wishlistProducts = wishListPage.getProductsList();

        ItemPage itemPage = wishlistProducts.get(0).openItemPage(driverManager.getDriver());

        String expected = productName;
        String actual = itemPage.getProductName();

        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driverManager.loadPage(SitePaths.wishlist);
        WishListPage wishListPage = new WishListPage(driverManager.getDriver());
        List<ProductRow> wishlistProducts = wishListPage.getProductsList();
        for (ProductRow product : wishlistProducts) {
            product.deleteFromWishList();
        }
        wishListPage = new WishListPage(driverManager.getDriver());
        wishListPage.getHeader().clickMyAccountDropdown();
        wishListPage.getHeader().clickLogout();
        driverManager.driverClose();
    }
}
