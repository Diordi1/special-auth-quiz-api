package com.quizweb.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

import com.quizweb.quiz.dao.questionsdao;
import com.quizweb.quiz.fucntions.question;

@Component
public class questionservice {

    @Autowired
    questionsdao qd;

    public List<question> getQuestions() {
        return qd.findAll();

    }

    public question createQuestions(question q) {
        return qd.save(q);

    }

    public List<question> getQuestion(String category, String difficulty, int id) {
        return qd.findQuestion(category, difficulty, id);

        // return qd.findByCategory(category);

    }
}
