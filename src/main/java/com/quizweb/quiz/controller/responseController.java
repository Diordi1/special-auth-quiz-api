package com.quizweb.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.quizweb.quiz.dao.quizdao;
import com.quizweb.quiz.fucntions.response;
import com.quizweb.quiz.service.responseservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/submit")
public class responseController {
    @Autowired
    responseservice rs;
    @Autowired
    quizdao qd;

    @PostMapping("/checkanswer")
    public ResponseEntity<?> postMethodName(@RequestBody List<response> res, @RequestParam String quizName) {
        // TODO: process POST request
        if (qd.findByQuizName(quizName).size() != 0) {
            return new ResponseEntity<>(rs.correctAnswers(res), HttpStatus.OK);

        } else {
            return new ResponseEntity<>("no quiz found", HttpStatus.BAD_REQUEST);

        }

        // return entity;
    }

}
