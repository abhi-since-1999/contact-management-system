package com.contact.management.system.services.impl;

import com.contact.management.system.entities.User;
import com.contact.management.system.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindByUsername() {
        // Given
        String username = "testUser";
        User user = new User();
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        // When
        Optional<User> result = userService.findByUsername(username);

        // Then
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void testSave() {
        // Given
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        // When
        User result = userService.save(user);

        // Then
        assertNotNull(result);
        assertEquals(user, result);
    }
}
