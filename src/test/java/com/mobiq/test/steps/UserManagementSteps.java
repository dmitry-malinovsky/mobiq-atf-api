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

    @When("REST request is sent to find user: {string}")
    public void requestsToSeeAllUsersIsSent(String userName) {
        User actorUser = userManagementActions.getUserByUsername(userName);
        Assert.assertNotNull(actorUser);
        Assert.assertEquals("User: " + userName + " found", actorUser.getUsername(), userName);
        context.saveData(UserManagementKeys.ACTOR_USER, actorUser);
    }
}