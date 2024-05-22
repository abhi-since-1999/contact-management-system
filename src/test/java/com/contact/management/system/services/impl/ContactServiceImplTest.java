package com.contact.management.system.services.impl;

import com.contact.management.system.entities.Contact;
import com.contact.management.system.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ContactServiceImplTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllContacts() {
        // Given
        List<Contact> contacts = new ArrayList<>();
        when(contactRepository.findAll()).thenReturn(contacts);

        // When
        List<Contact> result = contactService.getAllContacts();

        // Then
        assertNotNull(result);
        assertEquals(contacts, result);
    }

    @Test
    void testGetContactById() {
        // Given
        Long id = 1L;
        Contact contact = new Contact();
        when(contactRepository.findById(id)).thenReturn(Optional.of(contact));

        // When
        Contact result = contactService.getContactById(id);

        // Then
        assertNotNull(result);
        assertEquals(contact, result);
    }

    // Add tests for addContact, updateContact, and deleteContact methods
}
