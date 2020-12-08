package pages;

import java.util.concurrent.TimeUnit;
import lombok.EqualsAndHashCode;
import models.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@EqualsAndHashCode(callSuper = true)
public class SuccessfulRegistrationPage extends Page {
    private final WebElement heading;
    private final Header header;
    private final WebElement continueButton;

    public SuccessfulRegistrationPage(WebDriver driver) {
        super(driver, "Your Account Has Been Created!");
        header = new Header(driver);
        heading = this.driver.findElement(By.tagName("h1"));
        continueButton = this.driver.findElement(By.className("btn"));
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
