//package com.contact.management.system.auth;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.http.RequestEntity.post;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(AuthController.class)
//class AuthControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AuthService authService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private RegisterRequest registerRequest;
//    private AuthenticateRequest authenticateRequest;
//    private AuthenticationResponse authenticationResponse;
//
//    @BeforeEach
//    void setUp() {
//        registerRequest = new RegisterRequest();
//        // Set up registerRequest with required fields
//        registerRequest.setUserName("user");
//        registerRequest.setPassword("password");
//
//        authenticateRequest = new AuthenticateRequest();
//        // Set up authenticateRequest with required fields
//        authenticateRequest.setUserName("user");
//        authenticateRequest.setPassword("password");
//
//        authenticationResponse = new AuthenticationResponse();
//        // Set up authenticationResponse with required fields
//        authenticationResponse.setAccessToken("sample-token");
//    }
//
//    @Test
//    void testRegister() throws Exception {
//        given(authService.register(Mockito.any(RegisterRequest.class)))
//                .willReturn(authenticationResponse);
//
//        mockMvc.perform(post("/spring-security/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(registerRequest)))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(authenticationResponse)));
//    }
//
//    @Test
//    void testAuthenticate() throws Exception {
//        given(authService.authenticate(Mockito.any(AuthenticateRequest.class)))
//                .willReturn(authenticationResponse);
//
//        mockMvc.perform(post("/spring-security/auth/authenticate")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(authenticateRequest)))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(authenticationResponse)));
//    }
//}