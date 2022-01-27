package com.codegym.controller;

import com.codegym.dto.QuestionDto;
import com.codegym.model.entity.question.Question;
import com.codegym.model.entity.question.QuestionType;
import com.codegym.model.service.question.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ModelAttribute("questionTypeList")
    public List<QuestionType> showQuestionTypeList() {
        return questionService.findAllByQuestionType();
    }

    @GetMapping(value = {"/question", "/question/search"})
    public ModelAndView listQuestion(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam( value =  "titleSearch", defaultValue = "", required = false) String titleSearch,
                                     @RequestParam( value =  "typeIdSearch", defaultValue = "", required = false) String typeIdSearch) {


        ModelAndView modelAndView = new ModelAndView("question/list");
        Page<Question> questions = questionService.search(pageable , titleSearch , typeIdSearch);
        modelAndView.addObject("questions", questions);
        modelAndView.addObject("titleSearch", titleSearch);
        modelAndView.addObject("typeIdSearch", typeIdSearch);
        return modelAndView;
    }

    @GetMapping("/delete-question")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Question question = questionService.findById(id);
        questionService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Question deleted successfully!!!");
        return "redirect:/question";
    }

    @GetMapping("/create-question")
    public String showCreateForm(Model model) {
        model.addAttribute("questionDto", new QuestionDto());
        return "question/create";
    }

    @PostMapping({"/create-question"})
    public String saveQuestion(@Valid @ModelAttribute("questionDto") QuestionDto questionDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new QuestionDto().validate(questionDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "question/create";
        } else {
            Question question = new Question();
            BeanUtils.copyProperties(questionDto, question);
            questionService.save(question);
            redirectAttributes.addFlashAttribute("message", "Question created successfully!!!");
            return "redirect:/question";
        }
    }

    @GetMapping("/edit-question/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Question question = questionService.findById(id);
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question, questionDto);
        model.addAttribute("questionDto", questionDto);
        return "question/edit";
    }

    @PostMapping({"/edit-question"})
    public String updateCustomer(@Valid @ModelAttribute("questionDto") QuestionDto questionDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new QuestionDto().validate(questionDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "question/edit";
        } else {
            Question question = new Question();
            BeanUtils.copyProperties(questionDto, question);
            questionService.save(question);
            redirectAttributes.addFlashAttribute("message", "Question updated successfully!!!");
            return "redirect:/question";
        }
    }
}
