package com.quizweb.quiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller {
	
	@GetMapping("/")
    public String test() {
    	return "test completed";
    	
    }
}
