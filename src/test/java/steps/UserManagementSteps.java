package steps;

import actions.UserManagementActions;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagementSteps {

    @Autowired
    private UserManagementActions userManagementActions;

    @When("^requests to see all users is sent$")
    public void requestsToSeeAllUsersIsSent() throws Throwable {
        userManagementActions.getUsers();
    }
}
