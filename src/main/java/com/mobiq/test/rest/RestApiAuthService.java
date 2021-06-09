package com.mobiq.test.rest;

import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.beust.jcommander.internal.Lists.newArrayList;

import java.util.ArrayList;

@Service
public class RestApiAuthService {

    @Autowired
    private AuthenticationConfig authenticationConfig;

    public RequestSpecification addAuthRequestSpecification(RequestSpecification requestSpecification, UserCredentials userCredentials) {
        if (authenticationConfig.getEnableTokenAuthentication()) {
            return getTokenAuth(requestSpecification, userCredentials.getToken());
        } else {
            return addAuth(requestSpecification, userCredentials);
        }
    }

    public RequestSpecification addAuth(RequestSpecification baseSpec, UserCredentials userCredentials) {
        return ApiSpecUtils.updateSpec(baseSpec, newArrayList(new ApiSpecification(userCredentials)));
    }


    public RequestSpecification getTokenAuth(RequestSpecification baseSpec, String token){
        return ApiSpecUtils.updateSpec(baseSpec, newArrayList(new ApiSpecification(token)));
    }
}
