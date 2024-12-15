package com.quizweb.quiz;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.quizweb.quiz.auth.jwtfilter;

@SpringBootApplication
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Bean
	public SecurityFilterChain sec(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				http1 -> http1.requestMatchers("/questions/**", "/quiz/**").authenticated()
						.anyRequest().permitAll());
		http.httpBasic();
		http.addFilterBefore(new jwtfilter(), BasicAuthenticationFilter.class);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.headers().frameOptions().sameOrigin();
		http.csrf().disable();
		http.formLogin();

		return http.build();

	}

	// @Bean(initMethod = "start", destroyMethod = "stop")
	// public org.h2.tools.Server h2WebConsoleServer() throws SQLException {
	// return org.h2.tools.Server.createWebServer("-web", "-webAllowOthers",
	// "-webDaemon", "-webPort", "8080");
	// }

	@Bean
	public WebMvcConfigurer wec() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedHeaders("*")
						.allowedOrigins("*")
						.allowedMethods("*");

			}
		};
	}

}
