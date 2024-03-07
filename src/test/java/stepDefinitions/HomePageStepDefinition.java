package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import utils.TestContextSetup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePageStepDefinition {
    private final TestContextSetup mTestContext;
    private HomePage mHomePage;
    private final ArrayList<String> clickedItemTexts = new ArrayList<>();

    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.mTestContext = testContextSetup;
        mHomePage = mTestContext.mPageObjectManager.getHomePage();
    }

    @Then("Home page is displayed")
    public void home_page_is_displayed() throws InterruptedException {
        Assert.assertEquals("Incorrect Home page link", mHomePage.getUrl(), mTestContext.mDriver.getCurrentUrl());
        Thread.sleep(3000);
    }

    @When("User clicks the left navigation pane")
    public void user_clicks_the_left_navigation_pane() {
        mHomePage = mTestContext.mPageObjectManager.getHomePage();
        mHomePage.getLeftNavigationBtn().click();
    }

    @Then("Left navigation pane should display")
    public void left_navigation_pane_should_display() throws InterruptedException {
        Assert.assertTrue("Left navigation pane was not displayed", mHomePage.getLeftNavigationContainer().isDisplayed());
        Thread.sleep(3000);
    }

    @Then("Following Items should be displayed")
    public void following_items_should_be_displayed(List<String> expectedItems) throws InterruptedException {
        List<WebElement> actualItems = mHomePage.getProductItems();
        System.out.println(expectedItems.size());
        for (int i = 0; i < expectedItems.size(); i++) {
            System.out.println(actualItems.get(i).getText());
            System.out.println(actualItems.get(i).getText().equals(expectedItems.get(i)));
            Assert.assertEquals(actualItems.get(i).getText(), expectedItems.get(i));
        }

        Thread.sleep(3000);
    }

    @And("^Click an item to add to cart (.+)$")
    public void clickAnItemToAddToCart(int position) throws InterruptedException {
        forLogs(); //for logs

        List<WebElement> buttons = mHomePage.getAddToCartBtn();
        if (position >= 0 && position < buttons.size()) {
            WebElement button = buttons.get(position);
            button.click();
            if (position < mHomePage.getProductItemName().size()) {
                clickedItemTexts.add(mHomePage.getProductItemName().get(position).getText());

                System.out.println("clickedItemTexts" + clickedItemTexts);
                mHomePage.setClickedItems(clickedItemTexts);
            }

            String newButtonText = mHomePage.getAddToCartBtn().get(position).getText(); //call getAddToCartBtn again in order not to be stale
            Assert.assertEquals("Incorrect button text", "Remove", newButtonText);
        }
        Thread.sleep(3000);
    }

    private void forLogs() {
        System.out.println("mHomePage.getProductItemName().size() " + mHomePage.getProductItemName().size());
        for(int i = 0; i < mHomePage.getProductItemName().size(); i++) {
            System.out.println("position " + i + " " + mHomePage.getProductItemName().get(i).getText());
        }
    }

    @And("Click Cart button")
    public void clickCartButton() throws InterruptedException {
        mHomePage.getCartBtn().click();
        Thread.sleep(3000);
    }
}
