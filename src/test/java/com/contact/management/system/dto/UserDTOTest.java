package com.contact.management.system.dto;

import com.contact.management.system.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserDTOTest {

    @Test
    void testConstructorAndGetters() {
        // Given
        Long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        String username = "johndoe";
        String password = "password";
        Role role = Role.ADMIN;

        // When
        UserDTO userDTO = new UserDTO(id, firstName, lastName, username, password, role);

        // Then
        assertNotNull(userDTO);
        assertEquals(id, userDTO.getId());
        assertEquals(firstName, userDTO.getFirstName());
        assertEquals(lastName, userDTO.getLastName());
        assertEquals(username, userDTO.getUsername());
        assertEquals(password, userDTO.getPassword());
        assertEquals(role, userDTO.getRole());
    }

    @Test
    void testSetters() {
        // Given
        UserDTO userDTO = new UserDTO();
        Long id = 1L;
        String firstName = "John";
        String lastName = "Doe";
        String username = "johndoe";
        String password = "password";
        Role role = Role.ADMIN;

        // When
        userDTO.setId(id);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        userDTO.setRole(role);

        // Then
        assertEquals(id, userDTO.getId());
        assertEquals(firstName, userDTO.getFirstName());
        assertEquals(lastName, userDTO.getLastName());
        assertEquals(username, userDTO.getUsername());
        assertEquals(password, userDTO.getPassword());
        assertEquals(role, userDTO.getRole());
    }
}
