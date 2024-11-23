package dev.sharekindness.user.controller;

import dev.sharekindness.common.security.JwtUtil;
import dev.sharekindness.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        if (authService.authenticate(username, password)) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("role", "ADMIN"); // Example claim
            String token = jwtUtil.generateToken(username, claims);
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
