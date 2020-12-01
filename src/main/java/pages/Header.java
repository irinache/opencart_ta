package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    private WebElement menu;
    private WebElement myAccountDropdown;
    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
        this.menu = this.driver.findElement(By.className("list-inline"));
        this.myAccountDropdown = this.menu.findElement(By.className("dropdown"));
    }

    public void clickMyAccountDropdown() {
        this.myAccountDropdown.click();

    }

    public RegisterPage clickRegister() {
        WebElement RegisterOption = this.myAccountDropdown.findElement(By.className("dropdown-menu")).findElements(By.tagName("li")).get(0);
        RegisterOption.click();
        return new RegisterPage(this.driver);
    }

    public LoginPage clickLogin() {
        WebElement LoginOption = this.myAccountDropdown.findElement(By.className("dropdown-menu")).findElements(By.tagName("li")).get(1);
        LoginOption.click();
        return new LoginPage(this.driver);
    }

    public AccountLogoutPage clickLogout() {
        WebElement LogoutOption = this.myAccountDropdown.findElement(By.className("dropdown-menu")).findElements(By.tagName("li")).get(4);
        LogoutOption.click();
        return new AccountLogoutPage(driver);
    }
}
