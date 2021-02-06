package service;

import io.restassured.response.Response;
import model.User;

import java.util.List;

public interface UserManagementService {

    public Response getAllUsers();
}
