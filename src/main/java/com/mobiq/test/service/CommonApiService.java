package com.mobiq.test.service;

import com.mobiq.test.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CommonApiService {
    @Autowired
    private ApplicationProperties applicationProperties;

    public String getBaseUri(){
        return applicationProperties.getBaseUri();
    }
}
