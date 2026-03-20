package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    protected WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openMenu() {
        menuButton.click();
    }

    public void clickLogout() {
        logoutLink.click();
    }

    public void logout() {
        openMenu();
        clickLogout();
    }
}