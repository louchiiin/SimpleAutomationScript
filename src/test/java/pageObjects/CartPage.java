package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver mDriver;
    private WebDriverWait wait;
    private String cartPageUrl = "https://www.saucedemo.com/cart.html";
    By cartItemList = By.xpath("//div[@class='inventory_item_name']");
    By continueShoppingButton = By.xpath("//div[@class='cart_footer']/button[@id='continue-shopping']");

    public CartPage(WebDriver driver) {
        this.mDriver = driver;
    }

    public String getCartPageUrl() {
        return cartPageUrl;
    }

    public ArrayList<String> getProductNamesFromCartList() {
        ArrayList<String> productNames = new ArrayList<>();

        WebDriverWait wait = new WebDriverWait(mDriver, Duration.ofSeconds(10));

        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItemList));

        for (WebElement element : elements) {
            productNames.add(element.getText());
        }

        return productNames;
    }

    public WebElement getContinueShoppingBtn() {
        return mDriver.findElement(continueShoppingButton);
    }
}
