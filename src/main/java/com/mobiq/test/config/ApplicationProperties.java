package com.mobiq.test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api-configuration")
@Data
public class ApplicationProperties {
    private String contentType;
    private String baseUri;
}
