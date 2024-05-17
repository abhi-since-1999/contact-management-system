package com.contact.management.system.services;

import com.contact.management.system.entities.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    Contact addContact(Long id,Contact contact);
    Contact updateContact(Long id, Contact contact);
    boolean deleteContact(Long id);
}

