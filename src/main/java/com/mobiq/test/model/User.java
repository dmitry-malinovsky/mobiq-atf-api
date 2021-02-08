package com.mobiq.test.model;

import lombok.Builder;
import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private Geo geo;
    private String phone;
    private String website;
    private Company company;
}