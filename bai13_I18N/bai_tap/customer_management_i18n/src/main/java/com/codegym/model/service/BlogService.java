package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    void save(Blog blog);

    Blog findById(Long id);

    void deleteById(Long id);

    Page<Blog> findByBlogName(Pageable pageable, String name);

    Iterable<Blog> findAllByCategory(Category category);
}