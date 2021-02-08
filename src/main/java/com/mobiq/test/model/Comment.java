package com.mobiq.test.model;

import lombok.Data;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Data
public class Comment {
    private String postId;
    private String id;
    private String name;
    private String email;
    private String body;
}
