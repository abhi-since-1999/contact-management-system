package com.contact.management.system.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContactDTOTest {

    @Test
    void testConstructorAndGetters() {
        // Given
        Long id = 1L;
        String name = "John Doe";
        String phoneNumber = "1234567890";
        String email = "john@example.com";
        String additionalNotes = "Some additional notes";

        // When
        ContactDTO contactDTO = new ContactDTO(id, name, phoneNumber, email, additionalNotes);

        // Then
        assertNotNull(contactDTO);
        assertEquals(id, contactDTO.getId());
        assertEquals(name, contactDTO.getName());
        assertEquals(phoneNumber, contactDTO.getPhoneNumber());
        assertEquals(email, contactDTO.getEmail());
        assertEquals(additionalNotes, contactDTO.getAdditionalNotes());
    }

    @Test
    void testSetters() {
        // Given
        ContactDTO contactDTO = new ContactDTO();
        Long id = 1L;
        String name = "John Doe";
        String phoneNumber = "1234567890";
        String email = "john@example.com";
        String additionalNotes = "Some additional notes";

        // When
        contactDTO.setId(id);
        contactDTO.setName(name);
        contactDTO.setPhoneNumber(phoneNumber);
        contactDTO.setEmail(email);
        contactDTO.setAdditionalNotes(additionalNotes);

        // Then
        assertEquals(id, contactDTO.getId());
        assertEquals(name, contactDTO.getName());
        assertEquals(phoneNumber, contactDTO.getPhoneNumber());
        assertEquals(email, contactDTO.getEmail());
        assertEquals(additionalNotes, contactDTO.getAdditionalNotes());
    }
}
