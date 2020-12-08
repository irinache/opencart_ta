import drivers.DriverManager;
import drivers.SitePaths;
import pages.HomePage;
import models.ProductThumb;

public class Main {
    public static void main(String[] args) {
        DriverManager dm = new DriverManager();
        dm.configureDriver("opera");
        dm.loadPage(SitePaths.home);

        HomePage homePage = new HomePage(dm.getDriver());
        for(ProductThumb productThumb: homePage.getProductThumbs()){
            System.out.println(productThumb.getCaption());
        }
    }
}