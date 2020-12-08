package pages;

import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;

@EqualsAndHashCode(callSuper = true)
public class ReceiptPage extends Page{
    public ReceiptPage(WebDriver driver) {
        super(driver);
    }
}
