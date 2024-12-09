package com.quizweb.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quizweb.quiz.dao.questionsdao;
import com.quizweb.quiz.fucntions.question;
import com.quizweb.quiz.fucntions.response;

import java.util.*;

@Component
public class responseservice {
    @Autowired
    questionsdao qd;

    public answerStatus correctAnswers(List<response> res) {
        int totalQuestion = 0;
        int correctAnswers = 0;
        List<Long> wrong = new ArrayList<>();
        List<Long> correctAnswer = new ArrayList<>();

        for (int i = 0; i < res.size(); i++) {
            String rightanwer = (qd.findById(res.get(i).getQuestionID()).get().getRightoption());

            if (res.get(i).getSelectedOption().equals(rightanwer)) {
                correctAnswers++;
                correctAnswer.add(res.get(i).getQuestionID());

            } else {
                wrong.add(res.get(i).getQuestionID());

            }
            totalQuestion++;

        }
        return new answerStatus(totalQuestion, correctAnswers, totalQuestion - correctAnswers, wrong, correctAnswer);

    }

}

class answerStatus {
    int totalQuestions;
    int correctAnswers;
    int wrongAnswers;
    List<Long> wrong = new ArrayList<>();
    List<Long> correct = new ArrayList<>();

    public answerStatus(int totalQuestions, int correctAnswers, int wrongAnswers, List<Long> wrong,
            List<Long> correct) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
        this.wrong = wrong;
        this.correct = correct;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public List<Long> getWrong() {
        return wrong;
    }

    public void setWrong(List<Long> wrong) {
        this.wrong = wrong;
    }

    public List<Long> getCorrect() {
        return correct;
    }

    public void setCorrect(List<Long> correct) {
        this.correct = correct;
    }

    public answerStatus() {

    }
}