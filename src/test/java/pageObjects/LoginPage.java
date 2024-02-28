package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    By usernameXpath = By.xpath("//input[@id=\"user-name\"]");
    By passwordXpath = By.xpath("//input[@id=\"password\"]");
    By loginBtnXpath = By.xpath("//input[@id=\"login-button\"]");

    By errorMsgXpath = By.xpath("//h3[@data-test='error']");
    String mLoginUrl = "https://www.saucedemo.com/";

    private WebDriver mDriver;

    public LoginPage(WebDriver driver) {
        mDriver = driver;
    }

    public void loginToApp(String username, String password) {
        WebElement userNameField = userNameField();
        userNameField.sendKeys(username);

        WebElement passwordField =passwordField();
        passwordField.sendKeys(password);

        WebElement loginBtn = loginBtn();
        loginBtn.click();
    }

    public String getUrl() {
        return mLoginUrl;
    }

    public WebElement userNameField() {
        return mDriver.findElement(usernameXpath);
    }

    public WebElement passwordField() {
        return mDriver.findElement(passwordXpath);
    }

    public WebElement loginBtn() {
        return mDriver.findElement(loginBtnXpath);
    }

    public WebElement errorMessage() {
        return mDriver.findElement(errorMsgXpath);
    }

    public void getErrorMessage() {
        WebElement errorMsg = errorMessage();
        String errorText = errorMsg.getText().trim();
        System.out.println(errorText);
    }
}
