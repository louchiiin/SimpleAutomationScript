package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public HomePage mHomePage;
    public LoginPage mLoginPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return mHomePage = new HomePage(driver);
    }

    public LoginPage getLoginPage() {
        return mLoginPage = new LoginPage(driver);
    }
}
