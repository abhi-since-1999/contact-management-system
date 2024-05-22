package com.contact.management.system.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationResponseTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testNoArgsConstructor() {
        AuthenticationResponse response = new AuthenticationResponse();
        assertNull(response.getAccessToken());
    }

    @Test
    void testAllArgsConstructor() {
        AuthenticationResponse response = new AuthenticationResponse("sample-token");
        assertEquals("sample-token", response.getAccessToken());
    }

    @Test
    void testSettersAndGetters() {
        AuthenticationResponse response = new AuthenticationResponse();
        response.setAccessToken("sample-token");
        assertEquals("sample-token", response.getAccessToken());
    }

    @Test
    void testBuilder() {
        AuthenticationResponse response = AuthenticationResponse.builder()
                .accessToken("sample-token")
                .build();
        assertEquals("sample-token", response.getAccessToken());
    }

    @Test
    void testToString() {
        AuthenticationResponse response = new AuthenticationResponse("sample-token");
        String expected = "AuthenticationResponse(accessToken=sample-token)";
        assertEquals(expected, response.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        AuthenticationResponse response1 = new AuthenticationResponse("sample-token");
        AuthenticationResponse response2 = new AuthenticationResponse("sample-token");
        AuthenticationResponse response3 = new AuthenticationResponse("different-token");

        assertEquals(response1, response2);
        assertNotEquals(response1, response3);
        assertEquals(response1.hashCode(), response2.hashCode());
        assertNotEquals(response1.hashCode(), response3.hashCode());
    }

    @Test
    void testJsonSerialization() throws Exception {
        AuthenticationResponse response = new AuthenticationResponse("sample-token");
        String json = objectMapper.writeValueAsString(response);
        String expectedJson = "{\"access_token\":\"sample-token\"}";
        assertEquals(expectedJson, json);
    }

    @Test
    void testJsonDeserialization() throws Exception {
        String json = "{\"access_token\":\"sample-token\"}";
        AuthenticationResponse response = objectMapper.readValue(json, AuthenticationResponse.class);
        assertEquals("sample-token", response.getAccessToken());
    }
}
