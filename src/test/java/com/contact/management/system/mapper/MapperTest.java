package com.contact.management.system.mapper;

import com.contact.management.system.dto.ContactDTO;
import com.contact.management.system.dto.UserDTO;
import com.contact.management.system.entities.Contact;
import com.contact.management.system.entities.User;
import com.contact.management.system.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MapperTest {

    @Test
    void testMapToUserDTO() {
        // Given
        User user = new User(1L, "John", "Doe", "johndoe", "password", Role.MEMBER);

        // When
        UserDTO userDTO = Mapper.mapToUserDTO(user);

        // Then
        assertNotNull(userDTO);
        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getFirstName(), userDTO.getFirstName());
        assertEquals(user.getLastName(), userDTO.getLastName());
        assertEquals(user.getUsername(), userDTO.getUsername());
        assertEquals(user.getPassword(), userDTO.getPassword());
        assertEquals(user.getRole(), userDTO.getRole());
    }

    @Test
    void testMapToUser() {
        // Given
        UserDTO userDTO = new UserDTO(1L, "John", "Doe", "johndoe", "password", Role.MEMBER);

        // When
        User user = Mapper.mapToUser(userDTO);

        // Then
        assertNotNull(user);
        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getFirstName(), user.getFirstName());
        assertEquals(userDTO.getLastName(), user.getLastName());
        assertEquals(userDTO.getUsername(), user.getUsername());
        assertEquals(userDTO.getPassword(), user.getPassword());
        assertEquals(userDTO.getRole(), user.getRole());
    }

    @Test
    void testMapToContactDTO() {
        // Given
        Contact contact = new Contact(1L, "John Doe", "1234567890", "john@example.com", "Some additional notes");

        // When
        ContactDTO contactDTO = Mapper.mapToContactDTO(contact);

        // Then
        assertNotNull(contactDTO);
        assertEquals(contact.getId(), contactDTO.getId());
        assertEquals(contact.getName(), contactDTO.getName());
        assertEquals(contact.getPhoneNumber(), contactDTO.getPhoneNumber());
        assertEquals(contact.getEmail(), contactDTO.getEmail());
        assertEquals(contact.getAdditionalNotes(), contactDTO.getAdditionalNotes());
    }

    @Test
    void testMapToContact() {
        // Given
        ContactDTO contactDTO = new ContactDTO(1L, "John Doe", "1234567890", "john@example.com", "Some additional notes");

        // When
        Contact contact = Mapper.mapToContact(contactDTO);

        // Then
        assertNotNull(contact);
        assertEquals(contactDTO.getId(), contact.getId());
        assertEquals(contactDTO.getName(), contact.getName());
        assertEquals(contactDTO.getPhoneNumber(), contact.getPhoneNumber());
        assertEquals(contactDTO.getEmail(), contact.getEmail());
        assertEquals(contactDTO.getAdditionalNotes(), contact.getAdditionalNotes());
    }
}
