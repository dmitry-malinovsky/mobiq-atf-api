package com.mobiq.test.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiq.test.adapter.ApiAdapter;
import com.mobiq.test.model.User;
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

    public Response createUser(User user){
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = "";
        try {
            userJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       return apiService.put(getBaseUri() + "/users", userJson);
    }
}
