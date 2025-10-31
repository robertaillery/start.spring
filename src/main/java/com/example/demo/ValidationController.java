package com.example.demo;

import com.example.demo.dto.EmailRequest;
import com.example.demo.dto.PasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

 
    @PostMapping("/password-quality")
    public Map<String, String> passwordQuality(@RequestBody PasswordRequest request) {
        String quality = validationService.checkPasswordQuality(request.getPassword());
        return Map.of("quality", quality);
    }

   
    @PostMapping("/email-address-valid")
    public Map<String, Boolean> emailAddressValid(@RequestBody EmailRequest request) {
        boolean isValid = validationService.isValidEmail(request.getEmail());
        return Map.of("isValid", isValid);
    }
}