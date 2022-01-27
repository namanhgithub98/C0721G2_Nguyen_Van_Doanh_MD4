package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"/blogs", "/search"})
    public ModelAndView listBlogs(@PageableDefault(value = 3, sort = "startTime",direction = Sort.Direction.DESC) Pageable pageable,
                                  @RequestParam Optional<String> name) {
        String nameValue = "";
        if (name.isPresent()) {
            nameValue = name.get();
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        Page<Blog> blogs = blogService.findByBlogName(pageable, nameValue);
        modelAndView.addObject("nameValue", nameValue);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public String showCreateForm(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryList);
        return "/blog/create";
    }

    @PostMapping({"/create-blog"})
    public String saveBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New blog created successfully");
        return "redirect:/blogs";
    }

    @GetMapping("/edit-blog/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping({"/edit-blog"})
    public String updateBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Blog updated successfully");
        return "redirect:/blogs";
    }

    @GetMapping("/delete-blog/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.deleteById(blog.getId());
        return "redirect:/blogs";
    }

    @GetMapping("/view-blog/{id}")
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/blog/view";
    }
}