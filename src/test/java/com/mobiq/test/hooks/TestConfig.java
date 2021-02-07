package com.mobiq.test.hooks;


import com.mobiq.test.config.ApplicationConfiguration;
import com.mobiq.test.config.ApplicationProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = ApplicationConfiguration.class)
@EnableAutoConfiguration
@EnableConfigurationProperties(value = ApplicationProperties.class)

public class TestConfig {
}
