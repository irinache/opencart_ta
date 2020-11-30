import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SuccessfulRegistrationPage extends Page {
    private WebElement heading;
    private Header header;
    private WebElement continueButton;

    public SuccessfulRegistrationPage(WebDriver driver) {
        super(driver, "Your Account Has Been Created!");
        this.header = new Header(driver);
        this.heading = this.driver.findElement(By.tagName("h1"));
        this.continueButton = this.driver.findElement(By.className("btn"));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public void logout() {
        header.clickMyAccountDropdown();
        header.clickLogout();
    }

    public HomePage clickContinue() {
        continueButton.click();
        return new HomePage(driver);
    }
}
