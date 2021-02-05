package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/"},
        tags = "@Tag",
        glue = {
                "steps",
                "hooks"},
        plugin = {
                "json:target/cucumber.json", "pretty",
                "html:target/cucumber-reports"})
public class RunCucumberTest {
}