package com.mobiq.test.rest;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "config.backoffice.api.authentication")
public class AuthenticationConfig {
    private Boolean enableTokenAuthentication;
    private String defaultAlgorithm;
    private String defaultTokenType;
}
