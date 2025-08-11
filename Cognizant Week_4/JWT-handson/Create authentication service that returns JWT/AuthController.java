package com.cognizant.jwt_auth_service.controller;

import com.cognizant.jwt_auth_service.security.JwtUtil;  // ✅ FIXED package name
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
public class AuthController {

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header.");
        }

        try {
            // Decode Base64 encoded credentials
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded);
            String[] values = credentials.split(":", 2);

            if (values.length != 2) {
                return ResponseEntity.status(400).body("Invalid credentials format");
            }

            String username = values[0];
            String password = values[1];

            // Hardcoded check (demo purpose only)
            if ("user".equals(username) && "pwd".equals(password)) {
                String token = JwtUtil.generateToken(username);
                return ResponseEntity.ok().body(new JwtResponse(token)); // ✅ Return JSON object
            } else {
                return ResponseEntity.status(401).body("Invalid credentials");
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        }
    }

    // ✅ Inner class for JSON response
    static class JwtResponse {
        private String token;

        public JwtResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
