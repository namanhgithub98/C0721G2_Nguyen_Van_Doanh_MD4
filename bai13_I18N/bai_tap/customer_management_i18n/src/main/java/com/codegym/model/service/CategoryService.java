package com.codegym.model.service;

import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    void save(Category category);

    Category findById(Long id);

    void delete(Long id);
}