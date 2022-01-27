package com.codegym.model.entity.question;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionTypeId;
    private String questionTypeName;

    @OneToMany(mappedBy = "questionType")
    private Set<Question> questions;

    public QuestionType() {
    }

    public QuestionType(Integer questionTypeId, String questionTypeName, Set<Question> questions) {
        this.questionTypeId = questionTypeId;
        this.questionTypeName = questionTypeName;
        this.questions = questions;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
