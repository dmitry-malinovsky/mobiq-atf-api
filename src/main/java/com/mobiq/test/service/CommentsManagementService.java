package com.mobiq.test.service;

import io.restassured.response.Response;

public interface CommentsManagementService {

    public Response getAllComments();
    public Response getCommentsInPost(String id);
    public Response getCommentById(String id);
    public Response getCommentsByUser(String id);

}
