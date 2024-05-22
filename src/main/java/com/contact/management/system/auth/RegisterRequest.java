package com.contact.management.system.auth;

import com.contact.management.system.enums.Role;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Role role;
}
