package com.contact.management.system.contoller;

import com.contact.management.system.entities.Contact;
import com.contact.management.system.services.ContactService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ContactControllerTest {

    @Mock
    private ContactService contactService;

    @InjectMocks
    private ContactController contactController;

    public ContactControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllContacts() {
        // Given
        List<Contact> contacts = new ArrayList<>();
        when(contactService.getAllContacts()).thenReturn(contacts);

        // When
        List<Contact> result = contactController.getAllContacts();

        // Then
        assertEquals(contacts, result);
    }

    @Test
    void testGetContactById() {
        // Given
        Long id = 1L;
        Contact contact = new Contact();
        when(contactService.getContactById(id)).thenReturn(contact);

        // When
        ResponseEntity<Contact> result = contactController.getContactById(id);

        // Then
        assertEquals(contact, result.getBody());
    }

    @Test
    void testAddContact() {
        // Given
        Long id = 1L;
        Contact contact = new Contact();
        when(contactService.addContact(id, contact)).thenReturn(contact);

        // When
        ResponseEntity<Contact> result = contactController.addContact(id, contact);

        // Then
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(contact, result.getBody());
    }

    @Test
    void testUpdateContact() {
        // Given
        Long id = 1L;
        Contact contact = new Contact();
        when(contactService.updateContact(id, contact)).thenReturn(contact);

        // When
        ResponseEntity<Contact> result = contactController.updateContact(id, contact);

        // Then
        assertEquals(contact, result.getBody());
    }

    @Test
    void testDeleteContact() {
        // Given
        Long id = 1L;
        when(contactService.deleteContact(id)).thenReturn(true);

        // When
        ResponseEntity<String> result = contactController.deleteContact(id);

        // Then
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Contact deleted successfully", result.getBody());
    }
}
