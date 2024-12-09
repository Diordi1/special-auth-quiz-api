package com.quizweb.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.quizweb.quiz.fucntions.question;

@Component
public interface questionsdao extends JpaRepository<question, Long> {
    public question findByCategory(String category);

    @Query(value = "select * from question where category=:category or difficulty=:difficulty or id=:id", nativeQuery = true)
    public List<question> findQuestion(@Param("category") String category, @Param("difficulty") String difficulty,
            @Param("id") int id);

    @Query(value = "select * from question where category=:category order by RAND() limit :limit", nativeQuery = true)
    public List<question> randomquestion(@Param("category") String category, @Param("limit") int limit);

}
