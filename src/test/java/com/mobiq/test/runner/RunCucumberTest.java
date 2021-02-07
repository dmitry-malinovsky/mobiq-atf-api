package com.mobiq.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/"},
        tags = "@Tag",
        glue = {"com.mobiq.test.hooks",
                "com.mobiq.test.steps"},
        plugin = {
                "json:target/cucumber.json", "pretty",
                "html:target/cucumber-reports"})
public class RunCucumberTest {
}