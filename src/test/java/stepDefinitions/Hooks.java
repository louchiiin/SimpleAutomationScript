package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.IOException;

public class Hooks {
    private TestContextSetup mTestContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.mTestContextSetup = testContextSetup;
    }

    @Before()
    public void setUp() throws IOException {
        System.out.println("==== START OF saucedemo.com  TEST ====");
        System.out.println("....loading.....");
        mTestContextSetup.setPageObjectManager();
    }

    @After
    public void tearDown() throws IOException {
        System.out.println("==== END OF TEST ====");
        WebDriver driver = mTestContextSetup.mTestBase.getWebDriverManager();
        if(driver != null) {
            driver.close();
        }
    }
}
