package pages;

import java.util.concurrent.TimeUnit;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@EqualsAndHashCode(callSuper = true)
public class LoginPage extends Page {
    private final WebElement email;
    private final WebElement password;

    public LoginPage(WebDriver driver) {
        super(driver, "Account Login");
        email = this.driver.findElement(By.name("email"));
        password = this.driver.findElement(By.name("password"));

        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void setEmail(String data) {
        email.sendKeys(data);
    }

    public void setPassword(String data) {
        password.sendKeys(data);
    }

    public String getAlertText() {
        WebElement alert = driver.findElement(By.className("alert-danger"));
        return alert.getText();
    }

    public void clickLoginExpectingFailure() {
        email.submit();
    }

    public ProfilePage clickLogin() {
        email.submit();
        return new ProfilePage(driver);
    }
}
