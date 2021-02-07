package com.mobiq.test.actions;

import com.mobiq.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mobiq.test.service.impl.UserManagementServiceImpl;

import java.util.Arrays;
import java.util.List;

@Component
public class UserManagementActions {

    @Autowired
    private UserManagementServiceImpl userManagementService;

    public List<User> getUsers() {
        return Arrays.asList(userManagementService.getAllUsers().getBody().as(User[].class));
    }

    public User getUserById(String id) {
        return userManagementService.getUserById(id).getBody().as(User.class);
    }

    public User getUserByUsername(String userName) {
        return Arrays.stream(userManagementService.getUserByUsername(userName).as(User[].class)).findFirst().get();
    }
}
