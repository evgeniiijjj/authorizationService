package com.example.authorizationservice.service;

import com.example.authorizationservice.exception.InvalidCredentials;
import com.example.authorizationservice.repository.UserRepository;
import com.example.authorizationservice.util.Authorities;
import com.example.authorizationservice.exception.UnauthorizedUser;
import com.example.authorizationservice.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;


@Service
public class AuthorizationService {
    UserRepository userRepository;

    @Autowired
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder message = new StringBuilder();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                if (message.length() > 0) message.append(",\n");
                message.append(fieldError.getDefaultMessage());
            });
            throw new InvalidCredentials(message.toString());
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
