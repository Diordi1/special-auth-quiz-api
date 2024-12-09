package com.quizweb.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quizweb.quiz.dao.questionsdao;
import com.quizweb.quiz.dao.quizdao;
import com.quizweb.quiz.fucntions.question;
import com.quizweb.quiz.fucntions.quiz;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class quizservice {
    @Autowired
    quizdao qd;
    @Autowired
    questionsdao qs;

    public List<question> selectQuestions(String category, int limit) {
        List<question> quest = qs.randomquestion(category, limit);
        return quest;

    }

    public quiz createQuiz(String category, int limit, String name) {
        List<question> questions = selectQuestions(category, limit);
        quiz q1 = new quiz();
        q1.setQuizName(name);
        q1.setSelectQuestion(questions);
        q1.setCreatedDate(LocalDateTime.now());
        // LocalDateTime ld=LocalDateTime.now();
        return qd.save(q1);

    }
}
