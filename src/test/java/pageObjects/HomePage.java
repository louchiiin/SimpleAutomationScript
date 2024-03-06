package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver mDriver;
    private String homePageUrl = "https://www.saucedemo.com/inventory.html";
    private ArrayList<String> clickedItems = new ArrayList<>();
    By leftNavigationBtn = By.xpath("//button[@id='react-burger-menu-btn']");
    By leftNavigationContainer = By.xpath("//div[@class='bm-menu-wrap']");
    By productItems = By.xpath("//nav[@class='bm-item-list']/a");
    By addToCartBtnXpath = By.xpath("//button[contains(@class, 'btn_inventory')]\n");
    By productItemNameXpath = By.xpath("//div[@class='inventory_item_name ']");
    By cartBtnXpath = By.xpath("//div[@id='shopping_cart_container']");

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

    public WebElement getCartBtn() {
        return mDriver.findElement(cartBtnXpath);
    }

    public List<WebElement> getProductItems() {
        return mDriver.findElements(productItems);
    }

    public List<WebElement> getAddToCartBtn() {
        return mDriver.findElements(addToCartBtnXpath);
    }

    public List<WebElement> getProductItemName() {
        return mDriver.findElements(productItemNameXpath);
    }

    public void setClickedItems(ArrayList<String> itemsClicked) {
        clickedItems = itemsClicked;
    }

    public ArrayList<String> getClickedItems() {
        return clickedItems;
    }
}
