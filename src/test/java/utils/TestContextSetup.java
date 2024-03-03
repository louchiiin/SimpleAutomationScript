package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;
import stepDefinitions.Hooks;

import java.io.IOException;

public class TestContextSetup {
    public WebDriver mDriver;
    public PageObjectManager mPageObjectManager;
    public TestBase mTestBase;

    public void setPageObjectManager() throws IOException {
        mTestBase = new TestBase();
        mDriver = mTestBase.getWebDriverManager();
        mPageObjectManager = new PageObjectManager(mDriver);
        new Hooks(this);
    }
}
