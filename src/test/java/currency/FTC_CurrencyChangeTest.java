package currency;

import drivers.DriverManager;
import drivers.SitePaths;
import models.ProductThumb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class FTC_CurrencyChangeTest {
    private DriverManager driverManager;
    private String currencySymbol;
    private String currencyName;

    public FTC_CurrencyChangeTest(String currencySymbol, String passwordConfirm) {
        this.currencySymbol = currencySymbol;
        this.currencyName = passwordConfirm;
    }

    @Before
    public void setUp() {
        driverManager = new DriverManager();
        driverManager.configureDriver("opera");
        driverManager.loadPage(SitePaths.home);
    }

    @Parameterized.Parameters
    public static Collection currencies() {
        return Arrays.asList(new Object[][] {
                {"€", "EUR"},
                {"£", "GBP"},
                {"$", "USD"}
        });
    }

    @Test
    public void currencyChangeTest() {
        HomePage homePage = new HomePage(driverManager.getDriver());
        homePage.getHeader().clickCurrency();
        homePage.getHeader().chooseCurrency(currencyName);

        ProductThumb product = homePage.getProductThumbs().get(0);
        assertTrue(product.getPrice().contains(currencySymbol));
    }

    @After
    public void tearDown() {
        driverManager.driverClose();
    }
}
