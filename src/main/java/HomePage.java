import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends Page {
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver, "Your Store");
        this.header = new Header(driver);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickMyAccount() {
        header.clickMyAccountDropdown();
    }

    public RegisterPage clickRegister() {
        return header.clickRegister();
    }

}
