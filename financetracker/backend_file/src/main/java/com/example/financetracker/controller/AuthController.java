package com.example.financetracker.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.financetracker.dto.AuthRequest;
import com.example.financetracker.dto.AuthResponse;
import com.example.financetracker.model.User;
import com.example.financetracker.service.AuthService;
import com.example.financetracker.security.JwtUtil;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    // ---------------- SIGNUP ------------------
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody AuthRequest req) {
        try {
            // Use email + password
            User user = new User();
            user.setEmail(req.getEmail());
            user.setPassword(req.getPassword());

            User saved = authService.signup(user);

            String token = jwtUtil.generateToken(saved.getEmail());

            return ResponseEntity.ok(new AuthResponse(token));

        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    // ---------------- LOGIN ------------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {

        User user = authService.authenticate(req.getEmail(), req.getPassword());
        if (user == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
