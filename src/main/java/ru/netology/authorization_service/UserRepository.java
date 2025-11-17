package ru.netology.authorization_service;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private static final Map<String, String> users = Map.of(
            "admin", "adminpass",
            "user1", "pass1"
    );

    private static final Map<String, List<Authorities>> authorities = Map.of(
            "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            "user1", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        System.out.println("USER=" + user + ", PASS=" + password); // для отладки
        String userPassword = users.get(user);
        if (userPassword != null && userPassword.equals(password)) {
            return authorities.getOrDefault(user, Collections.emptyList());
        }
        return Collections.emptyList();
    }
}
