package com.contact.management.system.auth;

import com.contact.management.system.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterRequestTest {

    @Test
    void testNoArgsConstructor() {
        RegisterRequest request = new RegisterRequest();
        assertNull(request.getFirstName());
        assertNull(request.getLastName());
        assertNull(request.getUserName());
        assertNull(request.getPassword());
        assertNull(request.getRole());
    }

    @Test
    void testAllArgsConstructor() {
        RegisterRequest request = new RegisterRequest("John", "Doe", "johndoe", "password", Role.ADMIN);
        assertEquals("John", request.getFirstName());
        assertEquals("Doe", request.getLastName());
        assertEquals("johndoe", request.getUserName());
        assertEquals("password", request.getPassword());
    }

    @Test
    void testSettersAndGetters() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setUserName("johndoe");
        request.setPassword("password");

        assertEquals("John", request.getFirstName());
        assertEquals("Doe", request.getLastName());
        assertEquals("johndoe", request.getUserName());
        assertEquals("password", request.getPassword());
    }

    @Test
    void testBuilder() {
        RegisterRequest request = RegisterRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .userName("johndoe")
                .password("password")
                .build();

        assertEquals("John", request.getFirstName());
        assertEquals("Doe", request.getLastName());
        assertEquals("johndoe", request.getUserName());
        assertEquals("password", request.getPassword());
    }

    @Test
    void testEqualsAndHashCode() {
        RegisterRequest request1 = new RegisterRequest("John", "Doe", "johndoe", "password", Role.ADMIN);
        RegisterRequest request2 = new RegisterRequest("John", "Doe", "johndoe", "password", Role.ADMIN);
        RegisterRequest request3 = new RegisterRequest("Jane", "Smith", "janesmith", "differentPassword", Role.ADMIN);

        assertEquals(request1, request2);
        assertNotEquals(request1, request3);
        assertEquals(request1.hashCode(), request2.hashCode());
        assertNotEquals(request1.hashCode(), request3.hashCode());
    }
}
