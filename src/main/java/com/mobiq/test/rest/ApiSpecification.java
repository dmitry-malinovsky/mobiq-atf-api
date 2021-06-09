package com.mobiq.test.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiSpecification {
    private String specification;
    private String key;
    private String value;

    public ApiSpecification(UserCredentials userCredentials){
        this("auth", userCredentials.getUsername(), userCredentials.getPassword());
    }

    public ApiSpecification(String token){
        this("token-auth", "token", token );
    }
}
