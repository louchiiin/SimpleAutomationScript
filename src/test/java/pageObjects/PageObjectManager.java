package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public HomePage mHomePage;
    public LoginPage mLoginPage;
    public CartPage mCartPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (mHomePage == null) {
            mHomePage = new HomePage(driver);
        }
        return mHomePage;
    }

    public LoginPage getLoginPage() {
        if (mLoginPage == null) {
            mLoginPage = new LoginPage(driver);
        }
        return mLoginPage;
    }

    public CartPage getCartPage() {
        if (mCartPage == null) {
            mCartPage = new CartPage(driver);
        }
        return mCartPage;
    }
}
