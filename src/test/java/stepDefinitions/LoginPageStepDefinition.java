package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import utils.TestContextSetup;

public class LoginPageStepDefinition {
    private final TestContextSetup mTestContext;
    private LoginPage mLoginPage;

    public LoginPageStepDefinition(TestContextSetup testContextSetup) {
        this.mTestContext = testContextSetup;
    }

    @Before()
    public void setUp() {
        System.out.println("==== START OF saucedemo.com  TEST ====");
        System.out.println("....loading.....");
        mTestContext.setPageObjectManager();
    }

    @After
    public void tearDown() {
        System.out.println("==== END OF TEST ====");
        if(mTestContext.mDriver != null) {
            mTestContext.mDriver.close();
        }
    }

    @Given("User is on landing page")
    public void user_is_on_landing_page() throws InterruptedException {
        mLoginPage = mTestContext.mPageObjectManager.getLoginPage();
        Assert.assertEquals("Incorrect login page", mLoginPage.getUrl(), mTestContext.mDriver.getCurrentUrl());
        Thread.sleep(3000);
    }

    @Given("Username, password and login button fields are displayed")
    public void checkIfLoginFieldsAndButtonAreDisplayed() throws InterruptedException {
        Assert.assertTrue("User name field is not displayed", mLoginPage.getUserNameField().isDisplayed());
        Assert.assertTrue("Password field is not displayed", mLoginPage.getPasswordField().isDisplayed());
        Assert.assertTrue("Login Button is not displayed", mLoginPage.getLoginBtn().isDisplayed());
        Thread.sleep(3000);
    }

    //@When("User login to application using username {string} and password {string}") --> this will accepts string only
    @When("^User login to application using username (.+)and password (.+)$") //any data types will be accepted, add also ^ and $
    public void user_login_to_application(String username, String password) throws InterruptedException {
        mLoginPage.loginToApp(username, password);
        Thread.sleep(3000);
    }

    @Then("Login error message is displayed")
    public void loginErrorMessageIsDisplayed() {
        Assert.assertTrue("Error Message is not displayed", mLoginPage.getErrorMessage().isDisplayed());
    }

    @Then("Product items should be displayed")
    public void productItemsShouldBeDisplayed() throws InterruptedException {
        Assert.assertTrue("There are no available products", mLoginPage.getCountOfProducts() > 0);
        Thread.sleep(3000);
    }
}
