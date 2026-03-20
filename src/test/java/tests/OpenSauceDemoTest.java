package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSauceDemoTest extends BaseTest {

    @Test
    public void openSauceDemo() {
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }
}