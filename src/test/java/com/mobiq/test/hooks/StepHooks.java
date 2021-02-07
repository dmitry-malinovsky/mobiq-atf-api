package com.mobiq.test.hooks;

import com.mobiq.test.context.ScenarioContext;
import groovy.util.logging.Log4j;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(classes = {TestConfig.class})
@Log4j
public class StepHooks {

    @Autowired
    private ScenarioContext scenarioContext;

    @Before
    public void setUp() {
        scenarioContext.resetContext();
    }
}
