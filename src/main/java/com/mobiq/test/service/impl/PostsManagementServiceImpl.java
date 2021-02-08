package com.mobiq.test.service.impl;

import com.mobiq.test.adapter.ApiAdapter;
import com.mobiq.test.service.CommonApiService;
import com.mobiq.test.service.PostsManagementService;
import com.mobiq.test.service.UserManagementService;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PostsManagementServiceImpl extends CommonApiService implements PostsManagementService {

    @Autowired
    private ApiAdapter apiService;

    @Override
    public Response getAllPosts() {
        return apiService.get(getBaseUri() + "/posts");
    }

    @Override
    public Response getPostsByUser(String id) {
        return apiService.get(getBaseUri() + "/posts?userId=" + id);
    }

    @Override
    public Response getPostById(String id) {
        return apiService.get(getBaseUri() + "/posts/" + id);
    }
}
