package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {

    private final ValidationService validationService = new ValidationService();

    @Test
    void testPasswordQuality() {
        assertEquals("Weak", validationService.checkPasswordQuality("12345"));
        assertEquals("Weak", validationService.checkPasswordQuality("abcdefg"));
        assertEquals("Medium", validationService.checkPasswordQuality("12345678"));
        assertEquals("Medium", validationService.checkPasswordQuality("abcdefgH"));
        assertEquals("Medium", validationService.checkPasswordQuality("abc123def"));
        assertEquals("Strong", validationService.checkPasswordQuality("Abc123def456!"));
        assertEquals("Invalid", validationService.checkPasswordQuality(null));
    }

    @Test
    void testEmailValidity() {
        assertTrue(validationService.isValidEmail("test@example.com"));
        assertTrue(validationService.isValidEmail("user.name@domain.co.uk"));
        assertFalse(validationService.isValidEmail("test@example"));
        assertFalse(validationService.isValidEmail("test.example.com"));
        assertFalse(validationService.isValidEmail("test@.com"));
        assertFalse(validationService.isValidEmail(null));
    }
}