package com.mobiq.test.steps;

import com.mobiq.test.actions.CommentsManagementActions;
import com.mobiq.test.actions.PostsManagementActions;
import com.mobiq.test.actions.UserManagementActions;
import com.mobiq.test.context.ScenarioContext;
import com.mobiq.test.model.Comment;
import com.mobiq.test.model.Post;
import com.mobiq.test.model.User;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.mobiq.test.context.PostsManagementKeys.POSTS_BY_ACTOR_USER;
import static com.mobiq.test.context.UserManagementKeys.ACTOR_USER;

public class CommentsManagementSteps {
    @Autowired
    private PostsManagementActions postsManagementActions;

    @Autowired
    private UserManagementActions userManagementActions;

    @Autowired
    private CommentsManagementActions commentsManagementActions;

    @Autowired
    private ScenarioContext context;

    @When("all actor user posts have email of right format")
    public void checkIfUserHasPosts() {
        List<Post> posts = (List<Post>)context.getData(POSTS_BY_ACTOR_USER);
        List<Comment> allCommentsForPosts = commentsManagementActions.getAllCommentsForPosts(posts);
        Assert.assertTrue("All emails in comments of correct format",
                commentsManagementActions.validateEmailInComments(allCommentsForPosts));
    }
}
