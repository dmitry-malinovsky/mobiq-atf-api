package com.mobiq.test.steps;

import com.mobiq.test.actions.UserManagementActions;
import com.mobiq.test.context.ScenarioContext;
import com.mobiq.test.context.UserManagementKeys;
import com.mobiq.test.model.User;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;

public class UserManagementSteps {

    @Autowired
    private UserManagementActions userManagementActions;

    @Autowired
    private ScenarioContext context;

    @When("user with username {string} exists")
    public void checkIfUserExists(String userName) {
        User actorUser = userManagementActions.getUserByUsername(userName);
        Assert.assertNotNull("User does not exist", actorUser);
        Assert.assertEquals("User: " + userName + " found", actorUser.getUsername(), userName);
        context.saveData(UserManagementKeys.ACTOR_USER, actorUser);
    }

    @When("user with username: {string} does not exist")
    public void checkIfDoesNotUserExists(String userName) {
        User actorUser = userManagementActions.getUserByUsername(userName);
        Assert.assertNull("User already exists", actorUser);
    }

    @When("user with username: {string} is created")
    public void userIsCreated(String username) {
      Assert.assertEquals("Response code 201 in received",userManagementActions.createNewUser(username).getStatusCode(), 201 );
    }


}