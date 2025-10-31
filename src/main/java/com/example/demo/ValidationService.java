package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class ValidationService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );

   
    public String checkPasswordQuality(String password) {
        if (password == null || password.isEmpty()) {
            return "Invalid";
        }
        
        boolean hasLetter = password.matches(".*[a-zA-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        if (password.length() < 8) {
            return "Weak";
        } else if (password.length() >= 12 && hasLetter && hasNumber && hasSpecial) {
            return "Strong";
        } else if (password.length() >= 8 && (hasLetter || hasNumber)) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

 
    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }
}