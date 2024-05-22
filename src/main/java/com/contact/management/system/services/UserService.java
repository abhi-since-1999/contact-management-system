package com.contact.management.system.services;

import com.contact.management.system.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    User save(User user);
}
