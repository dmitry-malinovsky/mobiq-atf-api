package hooks;

import config.ApiProperties;
import config.BaseConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        BaseConfiguration.class
})
@EnableConfigurationProperties(
        ApiProperties.class
)
public class TestConfig {
}
