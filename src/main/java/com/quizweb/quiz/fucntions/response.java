package com.quizweb.quiz.fucntions;

public class response {

    Long questionID;
    String selectedOption;

    public response(Long questionID, String selectedOption) {
        this.questionID = questionID;
        this.selectedOption = selectedOption;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public response() {

    }

}
