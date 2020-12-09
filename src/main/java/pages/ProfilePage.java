package pages;

import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;

@EqualsAndHashCode(callSuper = true)
public class ProfilePage extends Page {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
