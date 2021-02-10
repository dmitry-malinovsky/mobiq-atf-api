package com.mobiq.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/"},
        tags = "@Regression",
        glue = {"com.mobiq.test.hooks",
                "com.mobiq.test.steps"},
        plugin = {
                "json:target/cucumber.json", "pretty",
                "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"})
public class RunCucumberTest {
}