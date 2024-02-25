package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MainSteps {
    public WebDriver mDriver;
    public WebDriverWait mDriverWait;
    //@Before("@TAGNAME")
    @Before()
    public void setUp() {
        System.out.println("==== START OF saucedemo.com  TEST ====");
        System.out.println("....loading.....");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver_windows_v122.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        mDriver = new ChromeDriver(chromeOptions);
        mDriver.manage().window().maximize();

        mDriver.get("https://www.saucedemo.com/");
        mDriverWait = new WebDriverWait(mDriver, Duration.ofSeconds(3000));
    }

    @After
    public void tearDown() {
        System.out.println("==== END OF TEST ====");
        if(mDriver != null) {
            mDriver.close();
        }
    }

    @Given("Username, password and login button fields are displayed")
    public void checkIfLoginFieldsAndButtonAreDisplayed() throws InterruptedException {
        WebElement userNameField = mDriver.findElement(By.xpath("//input[@id=\"user-name\"]"));
        Assert.assertTrue("User name field is not displayed", userNameField.isDisplayed());

        WebElement passwordField = mDriver.findElement(By.xpath("//input[@id=\"password\"]"));
        Assert.assertTrue("Password field is not displayed", passwordField.isDisplayed());

        WebElement loginBtn = mDriver.findElement(By.xpath("//input[@id='login-button']"));
        Assert.assertTrue("Login Button is not displayed", loginBtn.isDisplayed());

        Thread.sleep(3000);
    }

    @Given("User is on landing page")
    public void user_is_on_landing_page() throws InterruptedException {
        String url = "https://www.saucedemo.com/";
        Assert.assertEquals("Incorrect login page", url, mDriver.getCurrentUrl());
        Thread.sleep(3000);
    }

    //@When("User login to application using username {string} and password {string}") --> this will accepts string only
    @When("^User login to application using username (.+) and password (.+)$") //any data types will be accepted, add also ^ and $
    public void user_login_to_application(String username, String password) throws InterruptedException {

        WebElement userNameField = mDriver.findElement(By.xpath("//input[@id=\"user-name\"]"));
        userNameField.sendKeys(username);

        WebElement passwordField = mDriver.findElement(By.xpath("//input[@id=\"password\"]"));
        passwordField.sendKeys(password);

        WebElement loginBtn = mDriver.findElement(By.xpath("//input[@id=\"login-button\"]"));
        loginBtn.click();

        Thread.sleep(3000);
    }

    @Then("Home page is displayed")
    public void home_page_is_displayed() throws InterruptedException {
        String homePageUrl = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals("Incorrect Home page link", homePageUrl, mDriver.getCurrentUrl());
        if (!homePageUrl.equals(mDriver.getCurrentUrl())) {
            WebElement errorMsg = mDriver.findElement(By.xpath("//h3[@data-test='error']"));
            String errorText = errorMsg.getText().trim();
            System.out.println(errorText);
        }

        Thread.sleep(3000);
    }

    @When("User clicks the left navigation pane")
    public void user_clicks_the_left_navigation_pane() {
        WebElement webElement = mDriver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        webElement.click();
    }
    @Then("Left navigation pane should display")
    public void left_navigation_pane_should_display() throws InterruptedException {
        WebElement webElement = mDriver.findElement(By.xpath("//div[@class='bm-menu-wrap']"));
        Assert.assertTrue("Left navigation pane was not displayed", webElement.isDisplayed());
        Thread.sleep(2000);
    }
    @Then("Following Items should be displayed")
    public void following_items_should_be_displayed(List<String> expectedItems) throws InterruptedException {
        List<WebElement> actualItems = mDriver.findElements(By.xpath("//nav[@class='bm-item-list']/a"));
        System.out.println(expectedItems.size());
        for (int i = 0; i < expectedItems.size(); i++) {
            System.out.println(actualItems.get(i).getText());
            System.out.println(expectedItems.get(i));

            System.out.println(actualItems.get(i).getText().equals(expectedItems.get(i)));

            Assert.assertEquals(actualItems.get(i).getText(), expectedItems.get(i));
        }

        Thread.sleep(2000);
    }

    @Then("Product items should be displayed")
    public void productItemsShouldBeDisplayed() throws InterruptedException {
        WebElement invContainer = mDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        int itemCount = invContainer.findElements(By.className("inventory_item")).size();
        Assert.assertTrue("There are no available products", itemCount > 0);

        Thread.sleep(3000);
    }

    @When("User is on home page")
    public void userIsOnHomePage() throws InterruptedException {
        String url = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals("Incorrect home page", url, mDriver.getCurrentUrl());
        Thread.sleep(3000);
    }
}
