package pages;

import lombok.EqualsAndHashCode;
import models.Header;
import org.openqa.selenium.WebDriver;

@EqualsAndHashCode
public abstract class Page {
    protected final WebDriver driver;
    protected String pageTitle;
    private final Header header;

    public Page(WebDriver driver, String pageTitle) {
        this.driver = driver;
        this.pageTitle = pageTitle;
        header = new Header(driver);

        if (!pageTitle.equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the " + pageTitle + " page");
        }
    }
    public Page(WebDriver driver) {
        this.driver = driver;
        this.pageTitle = driver.getTitle();
        header = new Header(driver);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public Header getHeader(){
        return header;
    }

    public void clickMyAccount() {
        header.clickMyAccountDropdown();
    }

    public RegisterPage clickRegister() {
        return header.clickRegister();
    }

    public LoginPage clickLogin() {
        return header.clickLogin();
    }
}
