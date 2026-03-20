package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isProductsPageDisplayed());
    }
}