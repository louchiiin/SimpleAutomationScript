package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(// Path to your feature files
        features = "src/test/java/features",
        // Package where your step definitions are located
        monochrome = true,
        glue = "stepDefinitions",
        // Specify the report formats
        plugin = {"html:target/cucumber-reports.html", "json:target/cucumber_json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"}
        //for specified scenarios only
        ,tags = "@Test5"
)
public class JunitTestRunner {

}

