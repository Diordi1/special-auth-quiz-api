package com.quizweb.quiz.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.quizweb.quiz.dao.authrep;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jwtfilter extends OncePerRequestFilter {
    @Autowired
    authrep ar;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String jwt1 = request.getHeader(jwtconstant.JWT_HEADER);
        if (jwt1 != null) {
            String jwt = jwt1.substring(7);
            SecretKey sk = Keys.hmacShaKeyFor(jwtconstant.PUBLIC_KEY.getBytes());
            Claims cc = Jwts.parser().setSigningKey(sk).build().parseClaimsJws(jwt).getBody();
            String email = String.valueOf(cc.get("email"));
            System.out.println(email);
            // List<String> authorities = ar.findByEmail(email).getGrant();

            String authorites = String.valueOf(cc.get("grant"));
            String auth4 = authorites.replace("[", "");
            String auth5 = auth4.replace("]", "");

            System.out.println();
            System.out.println(auth5);
            // for (int i = 0; i < authorites.length(); i++) {
            // System.out.println(authorites.charAt(i));
            // }
            String splited[] = auth5.split(",");

            List<GrantedAuthority> autho = new ArrayList<>();

            for (int i = 0; i < splited.length; i++) {
                // System.out.println(splited[i]);
                autho.add(new SimpleGrantedAuthority(splited[i]));

            }
            // System.out.println(authorites.get);
            System.out.println(autho);
            Authentication auth = new UsernamePasswordAuthenticationToken(email, null, autho);
            SecurityContextHolder.getContext().setAuthentication(auth);

        } else {
            System.out.println("auth failed");
        }
        filterChain.doFilter(request, response);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'doFilterInternal'");
    }

}
