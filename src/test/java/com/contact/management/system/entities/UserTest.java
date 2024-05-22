package com.contact.management.system.entities;

import com.contact.management.system.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testEntityMappingAndConstructor() {
        // Given
        Long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        String username = "johndoe";
        String password = "password";
        Role role = Role.ADMIN;

        // When
        User user = new User(id, firstName, lastName, username, password, role);

        // Then
        assertNotNull(user);
        assertEquals(id, user.getId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getRole());
    }

    @Test
    void testGetAuthorities() {
        // Given
        Long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        String username = "johndoe";
        String password = "password";
        Role role = Role.ADMIN;

        // When
        User user = new User(id, firstName, lastName, username, password, role);
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) user.getAuthorities();

        // Then
        assertNotNull(authorities);
        assertFalse(authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    // Add tests for other UserDetails interface methods if needed
}
