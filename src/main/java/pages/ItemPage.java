package pages;

import models.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage extends Page {
    WebElement productName;
    public ItemPage(WebDriver driver) {
        super(driver);
        productName = driver.findElement(By.id("content")).findElement(By.tagName("h1"));
    }
    public String getProductName(){
        return productName.getText();
    }
}
