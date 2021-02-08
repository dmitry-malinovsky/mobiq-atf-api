package com.mobiq.test.service.impl;

import com.mobiq.test.adapter.ApiAdapter;
import com.mobiq.test.service.CommonApiService;
import com.mobiq.test.service.UserManagementService;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Business oriented steps implementation oriented on Comments business domain
 */

@Component
public class UserManagementServiceImpl extends CommonApiService implements UserManagementService {

    @Autowired
    private ApiAdapter apiService;

    public Response getAllUsers() {
        return apiService.get(getBaseUri() + "/users");
    }

    @Override
    public Response getUserById(String id) {
        return apiService.get(getBaseUri() + "/users/" + id);
    }

    public Response getUserByUsername(String userName) {
        return apiService.get(getBaseUri() + "/users?username=" + userName);
    }
}
