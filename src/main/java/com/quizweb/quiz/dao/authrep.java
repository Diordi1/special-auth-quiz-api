package com.quizweb.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.quizweb.quiz.fucntions.user;

@Component
public interface authrep extends JpaRepository<user, Long> {
    public user findByEmail(String email);

}
