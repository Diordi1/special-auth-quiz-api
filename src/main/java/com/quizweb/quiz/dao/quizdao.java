package com.quizweb.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;

import com.quizweb.quiz.fucntions.quiz;

@Component
public interface quizdao extends JpaRepository<quiz, Long> {

    public List<quiz> findByQuizName(String quizName);
}
