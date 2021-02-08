package com.mobiq.test.actions;

import com.mobiq.test.model.Post;
import com.mobiq.test.model.User;
import com.mobiq.test.service.impl.PostsManagementServiceImpl;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Log4j
public class PostsManagementActions {

    @Autowired
    private PostsManagementServiceImpl postsManagementService;

    public List<Post> getAllPostsForUser(User user){
        log.info("Fetching posts for: " + user.getUsername() + ", id: " + user.getId());
        return Arrays.asList(postsManagementService.getPostsByUser(user.getId()).getBody().as(Post[].class));
    }
}
