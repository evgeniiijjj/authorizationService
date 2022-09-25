package com.example.authorizationservice.util;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;


@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Size(min = 2, max = 20, message = "user name must be between 2 and 20 characters long")
    private String user;

    @Size(min = 3, max = 20, message = "user password must be between 3 and 15 characters long")
    private String password;
}
