package com.mobiq.test.service;

import io.restassured.response.Response;

public interface PostsManagementService {

    public Response getAllPosts();

    public Response getPostsByUser(String id);

    public Response getPostById(String id);

}
