import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage extends Page {
    private WebElement menu;
    private WebElement myAccountDropdown;

    public HomePage(WebDriver driver) {
        super(driver, "Your Store");
        this.menu = this.driver.findElement(By.className("list-inline"));
        this.myAccountDropdown = this.menu.findElement(By.className("dropdown"));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickMyAccount(){
        this.myAccountDropdown.click();

    }

    public RegisterPage clickRegister(){
        WebElement RegisterOption = this.myAccountDropdown.findElement(By.className("dropdown-menu")).findElements(By.tagName("li")).get(0);
        RegisterOption.click();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return new RegisterPage(this.driver);
    }
}
