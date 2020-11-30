import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RegisterPage extends Page{
    private WebElement firstName;
    private WebElement form;

    public RegisterPage(WebDriver driver) {
        super(driver, "Register Account");
        this.firstName = this.driver.findElement(By.name("firstname"));
        this.form = this.driver.findElement(By.className("form-horizontal"));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void typeFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }


    public WebElement getError(WebElement field) {
        WebElement parent = getParent(field);
        WebElement error_elem = parent.findElement(By.className("text-danger"));
        return error_elem;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getParent(WebElement element) {
        return element.findElement(By.xpath("./.."));
    }

    public void submitRegister() {
        this.form.submit();
    }
}
