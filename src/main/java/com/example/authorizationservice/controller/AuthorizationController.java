package com.example.authorizationservice.controller;

import com.example.authorizationservice.service.AuthorizationService;
import com.example.authorizationservice.util.Authorities;
import com.example.authorizationservice.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class AuthorizationController {
    AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user, BindingResult bindingResult) {
        return service.getAuthorities(user, bindingResult);
    }
}
