package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.List;

public class Header {
    private final WebElement myAccountDropdown;
    private final WebElement currencyDropdown;
    private final WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
        WebElement menu = driver.findElement(By.className("list-inline"));
        myAccountDropdown = menu.findElement(By.className("dropdown"));
        currencyDropdown = driver.findElement(By.id("form-currency"));
    }

    public void clickMyAccountDropdown() {
        myAccountDropdown.click();
    }

    public RegisterPage clickRegister() {
        WebElement registerOption = myAccountDropdown.findElement(By.className("dropdown-menu"))
                .findElements(By.tagName("li"))
                .get(0);
        registerOption.click();
        return new RegisterPage(driver);
    }

    public LoginPage clickLogin() {
        WebElement loginOption = myAccountDropdown.findElement(By.className("dropdown-menu"))
                .findElements(By.tagName("li"))
                .get(1);
        loginOption.click();
        return new LoginPage(driver);
    }

    public AccountLogoutPage clickLogout() {
        WebElement logoutOption = myAccountDropdown.findElement(By.className("dropdown-menu"))
                .findElements(By.tagName("li"))
                .get(4);
        logoutOption.click();
        return new AccountLogoutPage(driver);
    }

    public ReceiptPage clickWishList() {
        WebElement wishListButton = driver.findElement(By.id("wishlist-total"));
        wishListButton.click();
        return new ReceiptPage(driver);
    }

    public void clickCurrency() {
        currencyDropdown.click();
    }

    public void chooseCurrency(String name) {
        WebElement currency = currencyDropdown.findElement(By.name(name));
        currency.click();
    }
}
