package pages;

import java.util.concurrent.TimeUnit;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;

@EqualsAndHashCode(callSuper = true)
public class HomePage extends Page {
    private final Header header;

    public HomePage(WebDriver driver) {
        super(driver, "Your Store");
        header = new Header(driver);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickMyAccount() {
        header.clickMyAccountDropdown();
    }

    public RegisterPage clickRegister() {
        return header.clickRegister();
    }

    public LoginPage clickLogin() {
        return header.clickLogin();
    }
}
