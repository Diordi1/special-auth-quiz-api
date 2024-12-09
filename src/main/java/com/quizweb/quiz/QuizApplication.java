package com.quizweb.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Bean
	public SecurityFilterChain sec(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(http1 -> http1.requestMatchers("/temper").authenticated().anyRequest().permitAll());
		http.headers().frameOptions().sameOrigin();
		http.csrf().disable();

		return http.build();

	}

}
