package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {
    public WebDriver mDriver;
    public PageObjectManager mPageObjectManager;
    public TestBase mTestBase;

    public void setPageObjectManager() {
        mTestBase = new TestBase();
        mDriver = mTestBase.WebDriverManager();
        mPageObjectManager = new PageObjectManager(mDriver);
    }
}
