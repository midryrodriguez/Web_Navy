package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseTest extends BaseTest {

    @Test
    public void completePurchaseFlow() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // login
        loginPage.login("standard_user", "secret_sauce");

        // validar products page
        Assert.assertTrue(productsPage.isProductsPageDisplayed());

        // agregar producto random
        productsPage.addRandomProductToCart();

        // ir al carrito
        productsPage.goToCart();

        // checkout
        cartPage.clickCheckout();

        // llenar datos
        checkoutPage.fillInformation("Juan", "Perez", "12345");

        // finalizar compra
        checkoutPage.finishPurchase();

        // validación final
        Assert.assertEquals(
                checkoutPage.getConfirmationMessage(),
                "Thank you for your order!"
        );
    }
}