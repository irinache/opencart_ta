package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductThumb {
    private static final  By imageSelector = By.className("image");
    private static final  By captionSelector = By.className("caption");
    private static final  By nameSelector = By.tagName("h4");

    private WebElement image;
    private WebElement caption;
    private WebElement parent;
    private List<WebElement> buttons;

    public ProductThumb(WebElement parent){
        image = parent.findElement(imageSelector);
        caption = parent.findElement(captionSelector);
    }
    public String getCaption(){
        return  caption.findElement(nameSelector).getText();
    }

}
