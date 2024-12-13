package com.quizweb.quiz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizweb.quiz.auth.jwtconstant;
import com.quizweb.quiz.dao.authrep;
import com.quizweb.quiz.fucntions.user;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/auth")
public class authcontroller {

    @Autowired
    authrep ar;

    @PostMapping("/signup")
    public ResponseEntity<?> postMethodName(@RequestBody user us) {
        // TODO: process POST request

        if (ar.findByEmail(us.getEmail()) == null) {
            user us1 = new user();
            us1.setEmail(us.getEmail());
            us1.setPassword(us.getPassword());
            us1.setGrant(us.getGrant());
            List<GrantedAuthority> auth = new ArrayList<>();
            ar.save(us1);

            for (int i = 0; i < us.getGrant().size(); i++) {
                auth.add(new SimpleGrantedAuthority("ROLE_" + us.getGrant().get(i)));

            }
            Authentication auth1 = new UsernamePasswordAuthenticationToken(us.getEmail(), null, auth);
            SecurityContextHolder.getContext().setAuthentication(auth1);
        } else {
            System.out.println("already exists");
        }
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public String postMethodName1(@RequestBody user us) {
        // TODO: process POST request
        if (ar.findByEmail(us.getEmail()) != null) {
            user temp = ar.findByEmail(us.getEmail());
            // System.out.println(us.getPassword());
            if (temp.getPassword().equals(us.getPassword())) {
                SecretKey sk = Keys.hmacShaKeyFor(jwtconstant.PUBLIC_KEY.getBytes());
                List<GrantedAuthority> authorities = new ArrayList<>();
                List<String> auth1 = new ArrayList<>();

                for (int i = 0; i < us.getGrant().size(); i++) {
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + us.getGrant().get(i)));
                    auth1.add("ROLE_" + us.getGrant().get(i));

                }
                String jwt = Jwts.builder().signWith(sk).setIssuedAt(new Date())
                        .setExpiration(new Date(new Date().getTime() + 60 * 60 * 60))
                        .claim("email", us.getEmail()).claim("grant", auth1).compact();
                Authentication auth = new UsernamePasswordAuthenticationToken(us.getEmail(), null, authorities);
                SecurityContextHolder.getContext().setAuthentication(auth);

                return jwt;

            } else {
                return "incorrect details";

            }

        } else {
            return "no user found";

        }

        // return entity;
    }

}
