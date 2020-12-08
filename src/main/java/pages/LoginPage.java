package pages;

import lombok.EqualsAndHashCode;
import models.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@EqualsAndHashCode(callSuper = true)
public class LoginPage extends Page {
    private LoginForm loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
        WebElement form = driver.findElements(By.tagName("form")).get(1);
        loginForm = new LoginForm(form);
    }

    public String getAlertText() {
        WebElement alert = driver.findElement(By.className("alert-danger"));
        return alert.getText();
    }
    public LoginForm getLoginForm() {
        return loginForm;
    }
}
