package com.contact.management.system.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JwtServiceIntegrationTest {

    @Autowired
    private JwtService jwtService;

    @Test
    void testGenerateTokenAndExtractUsername() {
        // Given
        UserDetails userDetails = new User("testuser", "password", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));

        // When
        String token = jwtService.generateToken(userDetails);
        String extractedUsername = jwtService.extractUsername(token);

        // Then
        assertThat(extractedUsername).isEqualTo("testuser");
    }

    @Test
    void testExtractClaim() {
        // Given
        UserDetails userDetails = new User("testuser", "password", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        String token = jwtService.generateToken(userDetails);

        // When
        Collection<SimpleGrantedAuthority> extractedAuthorities = jwtService.extractClaim(token, claims -> {
            String authorities = (String) claims.get("authorities");
            String[] authoritiesArray = authorities.split(",");
            return Collections.singletonList(new SimpleGrantedAuthority(authoritiesArray[0]));
        });

        // Then
        assertThat(extractedAuthorities).containsExactly(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
