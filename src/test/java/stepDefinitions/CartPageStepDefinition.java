package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.CartPage;
import utils.TestContextSetup;

import java.util.ArrayList;
import java.util.Collections;

public class CartPageStepDefinition {

    private final TestContextSetup mTestContext;
    private CartPage mCartPage;


    public CartPageStepDefinition(TestContextSetup testContextSetup) {
        this.mTestContext = testContextSetup;
        mCartPage = mTestContext.mPageObjectManager.getCartPage();
    }

    @And("Cart page is displayed")
    public void cartPageIsDisplayed() throws InterruptedException {
        Assert.assertEquals("Incorrect page", mCartPage.getCartPageUrl(), mTestContext.mDriver.getCurrentUrl());
        Thread.sleep(3000);
    }

    @Then("Product items is added to cart")
    public void productItemsIsAddedToCart() throws InterruptedException {
        System.out.println("list one = " + mTestContext.mPageObjectManager.getHomePage().getClickedItems());
        System.out.println("list two = " + mCartPage.getProductNamesFromCartList());
        Assert.assertTrue("Incorrect items was added", compareArrayLists(mTestContext.mPageObjectManager.getHomePage().getClickedItems(), mCartPage.getProductNamesFromCartList()));
        Thread.sleep(3000);
    }

    // Custom method to compare two ArrayLists irrespective of order
    public static boolean compareArrayLists(ArrayList<String> list1, ArrayList<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        // Sorting the lists
        Collections.sort(list1);
        Collections.sort(list2);

        // Comparing each element
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }

    @And("Click continue shopping button")
    public void clickContinueShoppingButton() throws InterruptedException {
        mCartPage.getContinueShoppingBtn().click();
        Assert.assertEquals("Incorrect home page", mTestContext.mPageObjectManager.getHomePage().getUrl(), mTestContext.mDriver.getCurrentUrl());
        Thread.sleep(3000);
    }
}
