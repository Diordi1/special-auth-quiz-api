package com.quizweb.quiz.controller;

import org.springframework.web.bind.annotation.RestController;

import com.quizweb.quiz.fucntions.quiz;
import com.quizweb.quiz.service.quizservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/quiz")
public class quizcontroller {
    @Autowired
    quizservice qs;

    @GetMapping("/createquiz")
    public quiz getMethodName(@RequestParam String category, @RequestParam int limit, @RequestParam String quizname) {
        return qs.createQuiz(category, limit, "quiz" + category + limit);

    }

}
