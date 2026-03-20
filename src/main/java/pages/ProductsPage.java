package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ProductsPage extends MenuPage {

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    @FindBy(className = "title")
    private WebElement title;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductsPageDisplayed() {
        return title.getText().equals("Products");
    }

    public void addRandomProductToCart() {
        Random random = new Random();
        int randomIndex = random.nextInt(products.size());
        WebElement selectedProduct = products.get(randomIndex);

        WebElement addToCartButton = selectedProduct.findElement(
                org.openqa.selenium.By.tagName("button")
        );
        addToCartButton.click();
    }

    public void addFirstNProductsToCart(int n) {
        for (int i = 0; i < n && i < products.size(); i++) {
            WebElement product = products.get(i);
            WebElement addToCartButton = product.findElement(
                    org.openqa.selenium.By.tagName("button")
            );
            addToCartButton.click();
        }
    }

    public void goToCart() {
        cartButton.click();
    }
}