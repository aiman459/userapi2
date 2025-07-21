package com.example.userapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistrationRequest request) {
        // Abhi database ka kaam baad mein karenge
        System.out.println("Received registration for: " + request.getName());
        return "User registered successfully!";
    }
}

