package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    By usernameXpath = By.xpath("//input[@id=\"user-name\"]");
    By passwordXpath = By.xpath("//input[@id=\"password\"]");
    By loginBtnXpath = By.xpath("//input[@id=\"login-button\"]");

    By errorMsgXpath = By.xpath("//h3[@data-test='error']");
    String mLoginUrl = "https://www.saucedemo.com/";

    private final WebDriver mDriver;

    public LoginPage(WebDriver driver) {
        mDriver = driver;
    }

    public void loginToApp(String username, String password) {
        WebElement userNameField = getUserNameField();
        username = username.equals("[blank]") ? " ": username;
        userNameField.sendKeys(username);

        WebElement passwordField = getPasswordField();
        password = password.equals("[blank]") ? " ": password;
        passwordField.sendKeys(password);

        WebElement loginBtn = getLoginBtn();
        loginBtn.click();
    }

    public String getUrl() {
        return mLoginUrl;
    }

    public WebElement getUserNameField() {
        return mDriver.findElement(usernameXpath);
    }

    public WebElement getPasswordField() {
        return mDriver.findElement(passwordXpath);
    }

    public WebElement getLoginBtn() {
        return mDriver.findElement(loginBtnXpath);
    }

    public WebElement getErrorMessage() {
        return mDriver.findElement(errorMsgXpath);
    }

    public void printErrorMessage() {
        WebElement errorMsg = getErrorMessage();
        String errorText = errorMsg.getText().trim();
        System.out.println(errorText);
    }

    public int getCountOfProducts() {
        WebDriverWait driverWait = new WebDriverWait(mDriver, Duration.ofSeconds(3000));
        WebElement invContainer = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        return invContainer.findElements(By.className("inventory_item")).size();
    }
}
