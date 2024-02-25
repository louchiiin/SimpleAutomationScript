package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Path to your feature files
        features = "src/test/java/features",
        // Package where your step definitions are located
        monochrome = true,
        glue = "stepDefinitions",
        // Specify the report formats
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        //for specified scenarios only
        tags = "@Test1"
)
public class TestNGRunner {

}
