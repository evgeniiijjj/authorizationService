package com.example.authorizationservice.repository;

import com.example.authorizationservice.util.User;
import com.example.authorizationservice.util.Authorities;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class UserRepository {
    private final ConcurrentHashMap<User, List<Authorities>> users;

    public UserRepository() {
        this.users = new ConcurrentHashMap<>();
        users.put(new User("Richard", "1234"), List.of(Authorities.READ, Authorities.WRITE));
        users.put(new User("Garry", "2345"), List.of(Authorities.READ, Authorities.DELETE));
        users.put(new User("Martin", "3456"), List.of(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(User user) {
        return users.get(user);
    }
}
