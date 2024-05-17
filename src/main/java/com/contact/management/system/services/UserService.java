package com.contact.management.system.services;

import com.contact.management.system.entities.User;

public interface UserService {
    User findByUsername(String username);
    User save(User user);
}
