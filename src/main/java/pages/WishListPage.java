package pages;

import lombok.EqualsAndHashCode;
import models.ProductRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
public class WishListPage extends Page {
    private List<ProductRow> productRows;
    public WishListPage(WebDriver driver) {
        super(driver);
        productRows = new ArrayList<>();
    }
    public List<ProductRow> getProductsList(){
        WebElement table = driver.findElement(By.id("content")).findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(WebElement productRow:rows){
            productRows.add(new ProductRow(productRow));
        }
        return productRows;
    }

    public ProfilePage clickContinue(){
        WebElement continueButton = driver.findElement(By.id("content")).findElement(By.className("btn"));
        continueButton.click();
        return new ProfilePage(driver);
    }

    public String getAlertText(){
        WebElement alert = driver.findElement(By.className("alert"));
        return alert.getText();
    }
}
