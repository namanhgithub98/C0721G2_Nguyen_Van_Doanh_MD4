package com.codegym.model.service.question;

import com.codegym.model.entity.question.Question;
import com.codegym.model.entity.question.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    List<QuestionType> findAllByQuestionType();
    Page<Question> search(Pageable pageable, String questionTitle, String questionTypeName);
    void save(Question question);
    void delete(Integer id);
    Question findById(Integer id);
}
