package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

/*@RunWith(Cucumber.class)*/
@CucumberOptions(
        // Path to your feature files
        features = "src/test/java/features",
        // Package where your step definitions are located
        monochrome = true,
        glue = "stepDefinitions",
        // Specify the report formats
        plugin = {"pretty", "html:target/cucumber-reports.html"}
        //for specified scenarios only
        ,tags = "@Test5"
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

    /*@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
}
