package com.contact.management.system.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoleTest {

    @Test
    void testEnumValues() {
        // Given
        Role[] expectedValues = {Role.MEMBER, Role.ADMIN};

        // When
        Role[] actualValues = Role.values();

        // Then
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void testEnumToString() {
        // Given
        Role role = Role.MEMBER;

        // When
        String roleString = role.toString();

        // Then
        assertEquals("MEMBER", roleString);
    }

    // Add more tests as needed to verify enum behavior
}
