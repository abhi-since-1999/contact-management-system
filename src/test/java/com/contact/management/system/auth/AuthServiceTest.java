package com.contact.management.system.auth;

import com.contact.management.system.config.JwtService;
import com.contact.management.system.entities.User;
import com.contact.management.system.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("John");
        registerRequest.setLastName("Doe");
        registerRequest.setUserName("johndoe");
        registerRequest.setPassword("password");

        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .username(registerRequest.getUserName())
                .password("encodedPassword")
                .role(registerRequest.getRole())
                .build();

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(jwtService.generateToken(any(User.class))).thenReturn("jwtToken");

        AuthenticationResponse response = authService.register(registerRequest);

        assertEquals("jwtToken", response.getAccessToken());
        verify(passwordEncoder).encode("password");
        verify(userRepository).save(any(User.class));
        verify(jwtService).generateToken(user);
    }

    @Test
    void testAuthenticate() {
        AuthenticateRequest authenticateRequest = new AuthenticateRequest();
        authenticateRequest.setUserName("johndoe");
        authenticateRequest.setPassword("password");

        User user = User.builder()
                .username("johndoe")
                .password("encodedPassword")
                .build();

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(user));
        when(jwtService.generateToken(any(User.class))).thenReturn("jwtToken");

        AuthenticationResponse response = authService.authenticate(authenticateRequest);

        assertEquals("jwtToken", response.getAccessToken());
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(userRepository).findByUsername("johndoe");
        verify(jwtService).generateToken(user);
    }
}
