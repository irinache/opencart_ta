package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    private final WebElement myAccountDropdown;
    private final WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
        WebElement menu = this.driver.findElement(By.className("list-inline"));
        myAccountDropdown = menu.findElement(By.className("dropdown"));
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
}
