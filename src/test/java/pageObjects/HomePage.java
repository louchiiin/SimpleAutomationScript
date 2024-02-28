package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver mDriver;
    private String homePageUrl = "https://www.saucedemo.com/inventory.html";
    By leftNavigationBtn = By.xpath("//button[@id='react-burger-menu-btn']");
    By leftNavigationContainer = By.xpath("//div[@class='bm-menu-wrap']");
    By productItems = By.xpath("//nav[@class='bm-item-list']/a");

    public HomePage(WebDriver driver) {
        this.mDriver = driver;
    }

    public String getUrl() {
        return homePageUrl;
    }

    public WebElement getLeftNavigationBtn() {
        return mDriver.findElement(leftNavigationBtn);
    }

    public WebElement getLeftNavigationContainer() {
        return mDriver.findElement(leftNavigationContainer);
    }

    public List<WebElement> getProductItems() {
        return mDriver.findElements(productItems);
    }
}
