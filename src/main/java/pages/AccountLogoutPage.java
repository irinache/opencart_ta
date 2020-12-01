package pages;

import java.util.concurrent.TimeUnit;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@EqualsAndHashCode(callSuper = true)
public class AccountLogoutPage extends Page {
    private final WebElement heading;
    private final Header header;
    private final WebElement continueButton;

    public AccountLogoutPage(WebDriver driver) {
        super(driver, "Account Logout");
        header = new Header(driver);
        heading = this.driver.findElement(By.tagName("h1"));
        continueButton = this.driver.findElement(By.className("btn"));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public HomePage clickContinue() {
        continueButton.click();
        return new HomePage(driver);
    }
}
