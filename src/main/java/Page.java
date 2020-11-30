import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    @Override
    public int hashCode() {
        return pageTitle.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Page other = (Page) obj;
        return this.pageTitle == other.pageTitle;
    }
}
