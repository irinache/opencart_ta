package pages;

import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;

@EqualsAndHashCode
public class Page {
    protected final WebDriver driver;
    protected String pageTitle;

    public Page(WebDriver driver, String pageTitle) {
        this.driver = driver;
        this.pageTitle = pageTitle;

        if (!pageTitle.equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the " + pageTitle + " page");
        }
    }
}
