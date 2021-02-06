package hooks;

import context.ScenarioContext;
import groovy.util.logging.Log4j;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = { TestConfig.class})
@Log4j
public class StepHooks {

    @Autowired
    private ScenarioContext scenarioContext;

    @Before
    public void setUp(){
        scenarioContext.resetContext();
    }
}
