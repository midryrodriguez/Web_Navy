package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class RemoveProductsTest extends BaseTest {

    @Test
    public void removeThreeProductsFromCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isProductsPageDisplayed());

        productsPage.addFirstNProductsToCart(3);
        productsPage.goToCart();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        Assert.assertEquals(cartPage.getCartItemsCount(), 3);

        cartPage.removeFirstNProducts(3);

        Assert.assertTrue(cartPage.isCartEmpty());
    }
}