package actions;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.impl.UserManagementServiceImpl;

import java.util.Arrays;
import java.util.List;

@Component
public class UserManagementActions {

    @Autowired
    private UserManagementServiceImpl userManagementService;

    public List<User> getUsers(){
       return Arrays.asList(userManagementService.getAllUsers().getBody().as(User[].class));
    }
}
