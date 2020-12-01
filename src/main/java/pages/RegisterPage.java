package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterPage extends Page {
    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement telephone;
    private WebElement password;
    private WebElement passwordConfirm;
    List<WebElement> subscribeRadioButtons;
    private WebElement privacyPolicyCheckbox;
    private WebElement form;

    public RegisterPage(WebDriver driver) {
        super(driver, "Register Account");
        this.firstName = this.driver.findElement(By.name("firstname"));
        this.lastName = this.driver.findElement(By.name("lastname"));
        this.email = this.driver.findElement(By.name("email"));
        this.telephone = this.driver.findElement(By.name("telephone"));
        this.password = this.driver.findElement(By.name("password"));
        this.passwordConfirm = this.driver.findElement(By.name("confirm"));
        this.subscribeRadioButtons = this.driver.findElements(By.className("radio-inline"));
        this.privacyPolicyCheckbox = this.driver.findElement(By.name("agree"));

        this.form = this.driver.findElement(By.className("form-horizontal"));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setFirstName(String data) {
        firstName.sendKeys(data);
    }

    public void setLastName(String data) {
        lastName.sendKeys(data);
    }

    public void setEmail(String data) {
        email.sendKeys(data);
    }

    public void setTelephone(String data) {
        telephone.sendKeys(data);
    }

    public void setPassword(String data) {
        password.sendKeys(data);
    }

    public void setPasswordConfirm(String data) {
        passwordConfirm.sendKeys(data);
    }

    public void setSubscribeRadioButton(Boolean data) {
        if (data){
            subscribeRadioButtons.get(0).click();
        } else{
            subscribeRadioButtons.get(1).click();
        }
    }

    public void clickPrivacyPolicy() {
        privacyPolicyCheckbox.click();
    }

    public String getErrorText(WebElement field) {
        WebElement parent = getParent(field);
        WebElement error_elem = parent.findElement(By.className("text-danger"));
        return error_elem.getText();
    }

    public String getAlertText(){
        WebElement alert = driver.findElement(By.className("alert-danger"));
        return alert.getText();
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getTelephone() {
        return telephone;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getPasswordConfirm() {
        return passwordConfirm;
    }

    public WebElement getParent(WebElement element) {
        return element.findElement(By.xpath("./.."));
    }

    public void clickContinueExpectingFailure() {
        this.form.submit();
    }

    public SuccessfulRegistrationPage clickContinue() {
        this.form.submit();
        return new SuccessfulRegistrationPage(driver);
    }
}
