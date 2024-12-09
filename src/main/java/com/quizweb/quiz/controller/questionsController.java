package com.quizweb.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizweb.quiz.fucntions.question;
import com.quizweb.quiz.service.questionservice;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("questions")
public class questionsController {
    @GetMapping("/1")
    public String test() {
        return "test";

    }

    @Autowired
    questionservice qs;

    @PostMapping("/add")
    public ResponseEntity<question> addQuestion(@RequestBody question q) {
        question temp = qs.createQuestions(q);
        if (temp != null)
            return new ResponseEntity<>(temp, HttpStatus.CREATED);

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/allquestions")
    public ResponseEntity<List<question>> getMethodName(@RequestParam int year) {
        if (year <= 2024)
            return new ResponseEntity<>(qs.getQuestions(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/question")
    public ResponseEntity<List<question>> getMethodName1(@RequestParam String category, @RequestParam String difficulty,
            @RequestParam int id) {
        List<question> temp = qs.getQuestion(category, difficulty, id);
        if (temp == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(temp, HttpStatus.OK);

    }

}
