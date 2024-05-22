package com.contact.management.system.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticateRequestTest {

    @Test
    void testNoArgsConstructor() {
        AuthenticateRequest request = new AuthenticateRequest();
        assertNull(request.getUserName());
        assertNull(request.getPassword());
    }

    @Test
    void testAllArgsConstructor() {
        AuthenticateRequest request = new AuthenticateRequest("user", "password");
        assertEquals("user", request.getUserName());
        assertEquals("password", request.getPassword());
    }

    @Test
    void testSettersAndGetters() {
        AuthenticateRequest request = new AuthenticateRequest();
        request.setUserName("user");
        request.setPassword("password");
        assertEquals("user", request.getUserName());
        assertEquals("password", request.getPassword());
    }

    @Test
    void testBuilder() {
        AuthenticateRequest request = AuthenticateRequest.builder()
                .userName("user")
                .password("password")
                .build();
        assertEquals("user", request.getUserName());
        assertEquals("password", request.getPassword());
    }

    @Test
    void testToString() {
        AuthenticateRequest request = new AuthenticateRequest("user", "password");
        String expected = "AuthenticateRequest(userName=user, password=password)";
        assertEquals(expected, request.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        AuthenticateRequest request1 = new AuthenticateRequest("user", "password");
        AuthenticateRequest request2 = new AuthenticateRequest("user", "password");
        AuthenticateRequest request3 = new AuthenticateRequest("differentUser", "password");

        assertEquals(request1, request2);
        assertNotEquals(request1, request3);
        assertEquals(request1.hashCode(), request2.hashCode());
        assertNotEquals(request1.hashCode(), request3.hashCode());
    }
}