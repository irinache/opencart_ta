package models;

import lombok.EqualsAndHashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ReceiptPage;

@EqualsAndHashCode
public class LoginForm {
    private final WebElement emailField;
    private final WebElement passwordField;
    private final WebElement parent;

    public LoginForm(WebElement form){
        emailField = form.findElement(By.id("input-email"));
        passwordField = form.findElement(By.id("input-password"));
        parent = form;
    }

    public void setEmail(String data) {
        emailField.sendKeys(data);
    }

    public void setPassword(String data) {
        passwordField.sendKeys(data);
    }

    public ReceiptPage submitForm(WebDriver driver) {
        parent.submit();
        return new ReceiptPage(driver);
    }
}
