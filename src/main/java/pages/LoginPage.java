package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends Page {
    private WebElement email;
    private WebElement password;

    public LoginPage(WebDriver driver) {
        super(driver, "Account Login");
        this.email = this.driver.findElement(By.name("email"));
        this.password = this.driver.findElement(By.name("password"));

        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void setEmail(String data) {
        email.sendKeys(data);
    }

    public void setPassword(String data) {
        password.sendKeys(data);
    }

    public String getAlertText(){
        WebElement alert = driver.findElement(By.className("alert-danger"));
        return alert.getText();
    }

    public void clickLoginExpectingFailure(){
        email.submit();
    }

    public ProfilePage clickLogin(){
        email.submit();
        return new ProfilePage(driver);
    }
}
