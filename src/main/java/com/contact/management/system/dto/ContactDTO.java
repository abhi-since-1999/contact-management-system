package com.contact.management.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContactDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String additionalNotes;
}
