package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    Page<Blog> findAllByBlogNameContaining(Pageable pageable, String name);

    Iterable<Blog> findAllByCategory(Category category);
}
