package com.quizweb.quiz.auth;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class jwtprovider {
    public String generateJwt(String username, String password) {
        SecretKey sk = Keys.hmacShaKeyFor(jwtconstant.PUBLIC_KEY.getBytes());
        String jwt = Jwts.builder().signWith(sk).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getSeconds() + 60 * 30))
                .claim("email", username).claim("role", "dummy")
                .compact();
        return jwt;

    }
}
