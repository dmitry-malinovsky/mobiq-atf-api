package com.mobiq.test.rest;

import io.restassured.specification.RequestSpecification;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

import static com.mobiq.test.rest.ApiSpecUtils.buildSpec;

@Data
@ConfigurationProperties("config.api")
public class ApiProperties {

    private Map<String, List<ApiSpecification>> apiSpecMap;

    private Map<PropertyId, String> propertyMap;

    private RequestSpecification getSpec(ApiServiceSpecId specName){
        return buildSpec(apiSpecMap.get(specName.getmSpecName())).urlEncodingEnabled(false);
    }
}
