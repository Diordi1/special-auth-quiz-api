package com.quizweb.quiz.fucntions;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.*;

@Entity
public class quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String quizName;

    @OneToMany
    @ElementCollection
    List<question> selectQuestion = new ArrayList<>();

    LocalDateTime createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public List<question> getSelectQuestion() {
        return selectQuestion;
    }

    public void setSelectQuestion(List<question> selectQuestion) {
        this.selectQuestion = selectQuestion;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public quiz(Long id, String quizName, List<question> selectQuestion, LocalDateTime createdDate) {
        this.id = id;
        this.quizName = quizName;
        this.selectQuestion = selectQuestion;
        this.createdDate = createdDate;
    }

    public quiz() {

    }
}
