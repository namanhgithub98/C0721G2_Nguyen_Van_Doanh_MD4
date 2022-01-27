package com.codegym.dto;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class QuestionDto implements Validator {
    public void validate(QuestionDto questionDto, BindingResult bindingResult) {
    }

    private Integer questionId;

    @NotEmpty
    @Pattern(regexp = "([A-Z][a-a])+$", message = "Khong dc de trong")
    private String questionTitle;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
