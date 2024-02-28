package pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver mDriver;
    private String homePageUrl = "https://www.saucedemo.com/inventory.html";

    public HomePage(WebDriver driver) {
        this.mDriver = driver;
    }

    public String getUrl() {
        return homePageUrl;
    }
}
