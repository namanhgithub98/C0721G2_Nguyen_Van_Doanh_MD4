package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.EmployeeDto;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.PositionEmpl;
import com.codegym.model.service.employee.EmployeeService;
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
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("divisionList")
    public List<Division> showDivisionList() {
        return employeeService.findAllByDivision();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> showEducationDegreeList() {
        return employeeService.findAllByEducationDegree();
    }

    @ModelAttribute("positionEmplList")
    public List<PositionEmpl> showPositionEmplList() {
        return employeeService.findAllByPositionEmpl();
    }

//    @GetMapping(value = {"/employee", "/employee/search"})
//    public ModelAndView listEmployee(@PageableDefault(value = 3) Pageable pageable,
//                                     @RequestParam Optional<String> name) {
//        String nameValue = "";
//        if (name.isPresent()) {
//            nameValue = name.get();
//        }
//        ModelAndView modelAndView = new ModelAndView("/employee/list");
//        Page<Employee> employees = employeeService.findByEmployeeName(pageable, nameValue);
//        modelAndView.addObject("nameValue", nameValue);
//        modelAndView.addObject("employees", employees);
//        return modelAndView;
//    }

    @GetMapping(value = {"/employee", "/employee/search"})
    public ModelAndView listEmployee(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam(value = "nameSearch", defaultValue = "", required = false) String nameSearch,
                                     @RequestParam( value =  "emailSearch", defaultValue = "", required = false) String emailSearch,
                                     @RequestParam( value =  "positionEmployee", defaultValue = "", required = false) String positionEmployee) {

        ModelAndView modelAndView = new ModelAndView("employee/list");
        Page<Employee> employees = employeeService.search(pageable , nameSearch , emailSearch, positionEmployee );
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("nameSearch", nameSearch);
        modelAndView.addObject("emailSearch",emailSearch);
        modelAndView.addObject("positionEmployee",positionEmployee);
        return modelAndView;
    }

    @PostMapping("/delete-employee")
    public String showDeleteForm(@RequestParam Optional<Integer> id, RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.findById(id.get());
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Employee deleted successfully!!!");
        return "redirect:/employee";
    }


    @GetMapping("/create-employee")
    public String showCreateForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }

    @PostMapping({"/create-employee"})
    public String checkValidation(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Employee created successfully!!!");
            return "redirect:/employee";
        }
    }

    @GetMapping("/edit-employee/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        return "/employee/edit";
    }

    @PostMapping({"/edit-employee"})
    public String updateEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "Employee updated successfully!!!");
            return "redirect:/employee";
        }
    }
}