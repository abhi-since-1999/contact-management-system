package com.contact.management.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String additionalNotes;

}
