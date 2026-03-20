package pages;

import org.openqa.selenium.By;
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

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

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

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void removeFirstNProducts(int n) {
        int times = Math.min(n, cartItems.size());

        for (int i = 0; i < times; i++) {
            List<WebElement> currentItems = driver.findElements(By.className("cart_item"));
            WebElement item = currentItems.get(0);
            WebElement removeButton = item.findElement(By.tagName("button"));
            removeButton.click();
        }
    }

    public boolean isCartEmpty() {
        return driver.findElements(By.className("cart_item")).isEmpty();
    }
}