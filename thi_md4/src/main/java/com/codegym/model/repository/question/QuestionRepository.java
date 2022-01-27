package com.codegym.model.repository.question;

import com.codegym.model.entity.question.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query(value = "select * from question where question_title like :titleSearch and question_type_id like :typeIdSearch" , nativeQuery = true)
    Page<Question> search(Pageable pageable, @Param("titleSearch")  String titleSearch ,
                          @Param("typeIdSearch")  String typeIdSearch);
}
