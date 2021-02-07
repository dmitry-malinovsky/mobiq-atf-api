package com.mobiq.test.service;

import io.restassured.response.Response;

public interface UserManagementService {

    public Response getAllUsers();
    public Response getUserById(String id);
    public Response getUserByUsername(String userName);
}
