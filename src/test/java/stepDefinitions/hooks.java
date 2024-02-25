package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class hooks {
    /*public WebDriver mDriver;

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
    }

    @After
    public void tearDown() {
        System.out.println("==== END OF TEST ====");
        if(mDriver != null) {
            mDriver.close();
        }
    }

    public WebDriver getWebDriver() {
        return mDriver;
    }*/
}



//Before -> Background -> Scenario -> After
