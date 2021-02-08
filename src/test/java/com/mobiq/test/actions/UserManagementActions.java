package com.mobiq.test.actions;

import com.mobiq.test.model.Address;
import com.mobiq.test.model.Company;
import com.mobiq.test.model.Geo;
import com.mobiq.test.model.User;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mobiq.test.service.impl.UserManagementServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@Log4j
public class UserManagementActions {

    @Autowired
    private UserManagementServiceImpl userManagementService;

    public List<User> getUsers() {
        log.info("Fetching all users");
        return Arrays.asList(userManagementService.getAllUsers().getBody().as(User[].class));
    }

    public User getUserById(String id) {
        log.info("Fetching user with id: " + id);
        return userManagementService.getUserById(id).getBody().as(User.class);
    }

    public User getUserByUsername(String userName) {
        try {
            log.info("Fetching user with username: " + userName);
            return Arrays.stream(userManagementService.getUserByUsername(userName).as(User[].class)).findFirst().get();
        } catch (NoSuchElementException e) {
            log.info("User could not be found");
        }
        return null;
    }

    public Response createNewUser(String userName){
        User user = generateNewUserWithCustomName(userName);
        return userManagementService.createUser(user);
    }

    //TODO: add possibility to generate object with data trough generator service
    public User generateNewUserWithCustomName(String username) {
        User user = new User();
        Company company = new Company();
        Address address = new Address();
        Geo geo = new Geo();

        user.setName("Test Name");
        user.setUsername(username);
        user.setPhone("123");
        user.setEmail("test@mail.com");
        user.setWebsite("test.com");

        company.setName("Testcompany");
        company.setBs("test");
        company.setCatchPhrase("TestPhrase");

        address.setCity("Test");
        address.setStreet("Test");

        geo.setLat("123");
        geo.setLng("123");
        user.setAddress(address);
        user.setGeo(geo);
        user.setCompany(company);

        return user;
    }
}
