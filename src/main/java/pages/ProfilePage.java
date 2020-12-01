package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends Page {
    public ProfilePage(WebDriver driver) {
        super(driver, "My Account");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
