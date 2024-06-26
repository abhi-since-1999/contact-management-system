package com.contact.management.system.mapper;


import com.contact.management.system.dto.ContactDTO;
import com.contact.management.system.dto.UserDTO;
import com.contact.management.system.entities.Contact;
import com.contact.management.system.entities.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public static UserDTO mapToUserDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDTO userDto){
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword()
        );
    }

    public ContactDTO mapToContactDTO(Contact contact) {
        return new ContactDTO(
                contact.getId(),
                contact.getName(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getAdditionalNotes()
        );
    }

    public Contact mapToContact(ContactDTO contactDTO) {
        return new Contact(
                contactDTO.getId(),
                contactDTO.getName(),
                contactDTO.getPhoneNumber(),
                contactDTO.getEmail(),
                contactDTO.getAdditionalNotes()
        );
    }
}
