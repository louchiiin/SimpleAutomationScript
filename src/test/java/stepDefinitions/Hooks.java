package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
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
            driver.quit();
        }
    }

    @AfterStep
    public void AddScreenshotOnFail(Scenario scenario) throws IOException {
        WebDriver driver = mTestContextSetup.mTestBase.getWebDriverManager();
        if(scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }
}
