package pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProfilePage extends Page {
    public ProfilePage(WebDriver driver){
        super(driver, "My Account");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
