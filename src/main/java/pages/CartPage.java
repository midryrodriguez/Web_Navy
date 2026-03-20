package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends MenuPage {

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(className = "title")
    private WebElement title;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCartPageDisplayed() {
        return title.getText().equals("Your Cart");
    }

    public int getCartItemsCount() {
        return cartItems.size();
    }
}