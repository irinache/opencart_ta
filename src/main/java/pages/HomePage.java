package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.EqualsAndHashCode;
import models.Header;
import models.ProductThumb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@EqualsAndHashCode(callSuper = true)
public class HomePage extends Page {
    private List<ProductThumb> productThumbs;

    public HomePage(WebDriver driver) {
        super(driver, "Your Store");

        productThumbs = new ArrayList<>();
    }

    public List<ProductThumb> getProductThumbs() {
        List<WebElement> thumbs = driver.findElements(By.className("product-thumb"));
        for(WebElement thumb:thumbs){
            productThumbs.add(new ProductThumb(thumb));
        }
        return productThumbs;
    }

    public String getAlertText(){
        WebElement alert = driver.findElement(By.className("alert"));
        return alert.getText();
    }
}
