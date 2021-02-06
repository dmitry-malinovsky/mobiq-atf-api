package service.impl;

import adapter.ApiAdapter;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.CommonApiService;
import service.UserManagementService;

@Service
@Component
public class UserManagementServiceImpl extends CommonApiService implements UserManagementService {

    @Autowired
    private ApiAdapter apiService;

    public Response getAllUsers() {
        return apiService.get(getBaseUri() + "/users");
    }
}
