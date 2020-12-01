package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@EqualsAndHashCode(callSuper = true)
public class RegisterPage extends Page {
    private final WebElement firstName;
    private final WebElement lastName;
    private final WebElement email;
    private final WebElement telephone;
    private final WebElement password;
    private final WebElement passwordConfirm;
    private final WebElement privacyPolicyCheckbox;
    private final WebElement form;
    List<WebElement> subscribeRadioButtons;

    public RegisterPage(WebDriver driver) {
        super(driver, "Register Account");
        firstName = this.driver.findElement(By.name("firstname"));
        lastName = this.driver.findElement(By.name("lastname"));
        email = this.driver.findElement(By.name("email"));
        telephone = this.driver.findElement(By.name("telephone"));
        password = this.driver.findElement(By.name("password"));
        passwordConfirm = this.driver.findElement(By.name("confirm"));
        subscribeRadioButtons = this.driver.findElements(By.className("radio-inline"));
        privacyPolicyCheckbox = this.driver.findElement(By.name("agree"));

        form = this.driver.findElement(By.className("form-horizontal"));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setSubscribeRadioButton(boolean data) {
        if (data) {
            subscribeRadioButtons.get(0).click();
        } else {
            subscribeRadioButtons.get(1).click();
        }
    }

    public void clickPrivacyPolicy() {
        privacyPolicyCheckbox.click();
    }

    public String getErrorText(SearchContext field) {
        WebElement parent = getParent(field);
        WebElement errorElem = parent.findElement(By.className("text-danger"));
        return errorElem.getText();
    }

    public String getAlertText() {
        WebElement alert = driver.findElement(By.className("alert-danger"));
        return alert.getText();
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public void setFirstName(String data) {
        firstName.sendKeys(data);
    }

    public WebElement getLastName() {
        return lastName;
    }

    public void setLastName(String data) {
        lastName.sendKeys(data);
    }

    public WebElement getEmail() {
        return email;
    }

    public void setEmail(String data) {
        email.sendKeys(data);
    }

    public WebElement getTelephone() {
        return telephone;
    }

    public void setTelephone(String data) {
        telephone.sendKeys(data);
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(String data) {
        password.sendKeys(data);
    }

    public WebElement getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String data) {
        passwordConfirm.sendKeys(data);
    }

    public WebElement getParent(SearchContext element) {
        return element.findElement(By.xpath("./.."));
    }

    public void clickContinueExpectingFailure() {
        form.submit();
    }

    public SuccessfulRegistrationPage clickContinue() {
        form.submit();
        return new SuccessfulRegistrationPage(driver);
    }
}
