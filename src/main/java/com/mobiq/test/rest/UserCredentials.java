package com.mobiq.test.rest;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials {
    private String username;
    private String password;
    private String token;


    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
