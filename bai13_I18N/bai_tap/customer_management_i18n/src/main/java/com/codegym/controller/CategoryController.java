package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import com.codegym.model.service.BlogService;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/categorys")
    public String listCategorys(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Category> categorys = categoryService.findAll(pageable);
        model.addAttribute("categorys", categorys);
        return "/category/list";

    }
    @GetMapping("/create-category")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping({"/create-category"})
    public String saveBlog(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "New category created successfully");
        return "redirect:/categorys";
    }

    @GetMapping("/edit-category/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/edit";
    }

    @PostMapping({"/edit-category"})
    public String updateCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Category updated successfully");
        return "redirect:/categorys";
    }

    @GetMapping("/delete-category/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/delete";
    }

    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category) {
        categoryService.delete(category.getId());
        return "redirect:/categorys";
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id){
        Optional<Category> provinceOptional = Optional.ofNullable(categoryService.findById(id));
        Iterable<Blog> blogs = blogService.findAllByCategory(provinceOptional.get());
        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category", provinceOptional.get());
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
}