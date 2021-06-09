package com.mobiq.test.rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor (access = AccessLevel.PRIVATE )
public class ApiSpecUtils {

    public static RequestSpecification buildSpec(List<ApiSpecification> apiSpecificationList) {
        return updateSpec(new RequestSpecBuilder().build(), apiSpecificationList);
    }

    public static RequestSpecification updateSpec(RequestSpecification baseSpec, List<ApiSpecification> apiSpecificationList){
        Map<String, Map<String, Object>> apiSpecMap = apiSpecificationList
                .stream()
                .collect(Collectors.groupingBy(ApiSpecification::getSpecification,
                        Collectors.toMap(ApiSpecification::getKey, ApiSpecification::getValue)));
        apiSpecMap.forEach((k, v) -> ApiSpecificationParam.getSpec(k).buildReq(baseSpec, v));
    return baseSpec;
    }
}
