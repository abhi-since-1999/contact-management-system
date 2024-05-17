package com.contact.management.system.contoller;

import com.contact.management.system.entities.Contact;
import com.contact.management.system.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        return contact != null ? ResponseEntity.ok(contact) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Contact> addContact(@PathVariable Long id, @RequestBody Contact contact) {
        Contact addContact = contactService.addContact(id,contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(addContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Contact updatedContact = contactService.updateContact(id, contact);
        if(isNull(updatedContact)){
            System.out.println("Mja karo");
        }
        return updatedContact != null ? ResponseEntity.ok(updatedContact) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id) ?
                ResponseEntity.ok("Contact deleted successfully") :
                ResponseEntity.notFound().build();
    }
}
