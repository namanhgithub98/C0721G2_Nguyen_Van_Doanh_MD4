package com.codegym.model.entity.question;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private String questionTitle;
    private String questionQuestion;
    private String questionAnswer;

    @Column(name = "date_create", columnDefinition = "DATE")
    private String questionDate;
    private String questionStatus;

    @ManyToOne(targetEntity = QuestionType.class)
    @JoinColumn(name = "question_type_id", referencedColumnName = "questionTypeId")
    private QuestionType questionType;


    public Question() {
    }

    public Question(Integer questionId, String questionTitle, String questionQuestion, String questionAnswer, String questionDate, String questionStatus, QuestionType customerType) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionQuestion = questionQuestion;
        this.questionAnswer = questionAnswer;
        this.questionDate = questionDate;
        this.questionStatus = questionStatus;
        this.questionType = questionType;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionQuestion() {
        return questionQuestion;
    }

    public void setQuestionQuestion(String questionQuestion) {
        this.questionQuestion = questionQuestion;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(String questionDate) {
        this.questionDate = questionDate;
    }

    public String getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(String questionStatus) {
        this.questionStatus = questionStatus;
    }

    public QuestionType getCustomerType() {
        return questionType;
    }

    public void setCustomerType(QuestionType customerType) {
        this.questionType = customerType;
    }
}
