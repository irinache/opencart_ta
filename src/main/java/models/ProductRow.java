package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ItemPage;

import java.util.List;

public class ProductRow {
    private WebElement image;
    private WebElement caption;
    private List<WebElement> buttons;

    private static final By cellSelector = By.tagName("td");
    private static final By buttonSelector = By.className("btn");

    public ProductRow(WebElement row){
        image = row.findElements(cellSelector).get(0);
        caption = row.findElements(cellSelector).get(1).findElement(By.tagName("a"));
        buttons = row.findElements(buttonSelector);
    }

    public String getCaption(){
        return caption.getText();
    }

    public void addToCart(){
        buttons.get(0).click();
    }

    public void deleteFromWishList(){
        buttons.get(1).click();
    }

    public ItemPage openItemPage(WebDriver driver){
        caption.click();
        return new ItemPage(driver);
    }
}
