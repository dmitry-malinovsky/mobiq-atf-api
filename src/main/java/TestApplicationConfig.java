import config.ApiProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@ContextConfiguration(classes = ApiProperties.class)
@RunWith(SpringRunner.class)
public class TestApplicationConfig {

    @Autowired
    private ApiProperties apiProperties;

    @Test
    public void testConnection() {
        System.out.println(apiProperties);
    }
}

