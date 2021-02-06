package service;

import config.ApiProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonApiService {
    @Autowired
    private ApiProperties apiProperties;

    public String getBaseUri(){
        return apiProperties.getBaseUri();
    }
}
