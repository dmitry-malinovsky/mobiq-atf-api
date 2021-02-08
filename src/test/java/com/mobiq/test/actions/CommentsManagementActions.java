package com.mobiq.test.actions;

import com.mobiq.test.model.Comment;
import com.mobiq.test.model.Post;
import com.mobiq.test.model.User;
import com.mobiq.test.service.impl.CommentsManagementServiceImpl;
import com.mobiq.test.service.impl.PostsManagementServiceImpl;
import com.mobiq.test.utils.ValidationUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Log4j
public class CommentsManagementActions {

    @Autowired
    private CommentsManagementServiceImpl commentsManagementService;

    public List<Comment> getAllCommentsForPost(Post post) {
        log.info("Fetching comments for post: " + post.getId());
        return Arrays.asList(commentsManagementService.getCommentsInPost(post.getId()).getBody().as(Comment[].class));
    }

    public List<Comment> getAllCommentsForPosts(List<Post> posts) {
        List<Comment> allCommentsForPost = new ArrayList<>();
        for (Post post : posts) {
            allCommentsForPost.addAll(getAllCommentsForPost(post));
        }
        return allCommentsForPost;
    }

    public List<Comment> getAllCommentsForUser(User user) {
        log.info("Fetching comments for user: " + user.getId());
        return Arrays.asList(commentsManagementService.getCommentsByUser(user.getId()).getBody().as(Comment[].class));
    }

    public boolean validateEmailInComments(List<Comment> comments) {
        boolean isValid = false;
        for (Comment comment : comments) {
            log.info("Validating email: " + comment.getEmail());
            isValid = ValidationUtils.isValidEmailAddress(comment.getEmail());
        }
        return isValid;
    }
}
