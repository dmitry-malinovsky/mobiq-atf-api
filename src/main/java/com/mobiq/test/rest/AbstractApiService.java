package com.mobiq.test.rest;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.function.Supplier;

public abstract class AbstractApiService implements ApiService{
    private final static String request = "Request: {}";

    @Autowired
    protected ApiProperties apiProperties;

    @Autowired
    protected RestApiAuthService restApiAuthService;

    protected Supplier<RequestSperification> baseSpecSupplier;

    public abstract ApiServiceSpecId getSpecId();

    @PostConstruct
    private void init(){ baseSpecSupplier = () -> apiProperties.getSpec(getSpecId()); }
}
