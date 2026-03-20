package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected final String BASE_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}