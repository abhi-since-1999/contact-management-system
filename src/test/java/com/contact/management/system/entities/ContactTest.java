package com.contact.management.system.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContactTest {

    @Test
    void testEntityMappingAndConstructor() {
        // Given
        Long id = 1L;
        String name = "John Doe";
        String phoneNumber = "1234567890";
        String email = "john@example.com";
        String additionalNotes = "Some additional notes";

        // When
        Contact contact = new Contact(id, name, phoneNumber, email, additionalNotes);

        // Then
        assertNotNull(contact);
        assertEquals(id, contact.getId());
        assertEquals(name, contact.getName());
        assertEquals(phoneNumber, contact.getPhoneNumber());
        assertEquals(email, contact.getEmail());
        assertEquals(additionalNotes, contact.getAdditionalNotes());
    }

    @Test
    void testSetters() {
        // Given
        Contact contact = new Contact();
        Long id = 1L;
        String name = "John Doe";
        String phoneNumber = "1234567890";
        String email = "john@example.com";
        String additionalNotes = "Some additional notes";

        // When
        contact.setId(id);
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contact.setEmail(email);
        contact.setAdditionalNotes(additionalNotes);

        // Then
        assertEquals(id, contact.getId());
        assertEquals(name, contact.getName());
        assertEquals(phoneNumber, contact.getPhoneNumber());
        assertEquals(email, contact.getEmail());
        assertEquals(additionalNotes, contact.getAdditionalNotes());
    }
}
