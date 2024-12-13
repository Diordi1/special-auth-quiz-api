package com.quizweb.quiz.fucntions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.*;

@Entity
@Table(name = "onboard_users")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String email;
    String password;
    List<String> grant = new ArrayList<>();

    public user(Long id, String email, String password, List<String> grant) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.grant = grant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getGrant() {
        return grant;
    }

    public void setGrant(List<String> grant) {
        this.grant = grant;
    }

    public user() {

    }
}
