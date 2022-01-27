package com.codegym.model.service.question;

import com.codegym.model.entity.question.Question;
import com.codegym.model.entity.question.QuestionType;
import com.codegym.model.repository.question.QuestionRepository;
import com.codegym.model.repository.question.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAllByQuestionType() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Page<Question> search(Pageable pageable, String questionTitle, String questionTypeName) {
        return questionRepository.search(pageable, '%'+questionTitle+'%' , '%'+questionTypeName+'%');
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Question findById(Integer id) {
        return questionRepository.findById(id).get();
    }
}
