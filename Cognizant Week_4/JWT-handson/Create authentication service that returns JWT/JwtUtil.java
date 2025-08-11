package com.cognizant.jwt_auth_service.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "mysecretkey123"; // Simple key (for demo)

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 mins
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
