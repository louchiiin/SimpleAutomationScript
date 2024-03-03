package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver getWebDriverManager() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +"//src//test//resources//global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String url = properties.getProperty("QAUrl");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if(driver == null) {
            if(properties.getProperty("browser").equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver_windows_v122.exe");
            } else if(properties.getProperty("browser").equals("firefox")) {
                //other drivers e.g firefox
            }
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.get(url);
        }

        return driver;
    }
}
