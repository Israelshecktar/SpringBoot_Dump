package dev.sharekindness.user.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // Example method to handle user authentication
    public boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("password"); // Dummy implementation
    }

    // Example method to register a user
    public void registerUser(String username, String password) {
     
        System.out.println("User registered: " + username);
    }
}
