package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        tags = "@Todo",
        glue = "definitions",
        plugin = {"json:target/cucumber-report/cucumber.json","html:target/cucumber-report/index.html"})

public class testRunner {
}
