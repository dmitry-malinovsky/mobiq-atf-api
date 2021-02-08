package com.mobiq.test.service.impl;

import com.mobiq.test.adapter.ApiAdapter;
import com.mobiq.test.service.CommentsManagementService;
import com.mobiq.test.service.CommonApiService;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Business oriented steps implementation oriented on Comments business domain
 */

@Component
public class CommentsManagementServiceImpl extends CommonApiService implements CommentsManagementService {

    @Autowired
    private ApiAdapter apiService;

    @Override
    public Response getAllComments() {
        return apiService.get(getBaseUri() + "/comments");
    }

    @Override
    public Response getCommentsInPost(String id) {
        return apiService.get(getBaseUri() + "/posts/" + id + "/comments");
    }

    @Override
    public Response getCommentById(String id) {
        return apiService.get(getBaseUri() + "/comments/" + id);
    }

    @Override
    public Response getCommentsByUser(String id) {
        return apiService.get(getBaseUri() + "/users/ " + id + "/comments");
    }
}
