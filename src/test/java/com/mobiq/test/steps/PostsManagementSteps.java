package com.mobiq.test.steps;

import com.mobiq.test.actions.PostsManagementActions;
import com.mobiq.test.actions.UserManagementActions;
import com.mobiq.test.context.ScenarioContext;
import com.mobiq.test.model.Post;
import com.mobiq.test.model.User;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.mobiq.test.context.PostsManagementKeys.POSTS_BY_ACTOR_USER;
import static com.mobiq.test.context.UserManagementKeys.ACTOR_USER;

public class PostsManagementSteps {
    @Autowired
    private PostsManagementActions postsManagementActions;

    @Autowired
    private UserManagementActions userManagementActions;

    @Autowired
    private ScenarioContext context;

    @When("actor user has existing posts")
    public void checkIfUserHasPosts() {
        User user = (User) context.getData(ACTOR_USER);
        List<Post> allPostsForUser = postsManagementActions.getAllPostsForUser(user);
        Assert.assertTrue("Actor user has existing posts. ", allPostsForUser.size()>0);
        context.saveData(POSTS_BY_ACTOR_USER, allPostsForUser);
    }

    @When("{string} has existing posts")
    public void checkIfSpecificUserHasPosts(String userName) {
        User user = userManagementActions.getUserByUsername(userName);
        List<Post> allPostsForUser = postsManagementActions.getAllPostsForUser(user);
        Assert.assertTrue("User " + userName +"  has existing posts. ", allPostsForUser.size()>0);
        context.saveData(POSTS_BY_ACTOR_USER, allPostsForUser);
    }
}
