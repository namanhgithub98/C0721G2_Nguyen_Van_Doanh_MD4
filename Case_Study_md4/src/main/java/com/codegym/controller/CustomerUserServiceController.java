package com.codegym.controller;

import com.codegym.dto.CustomerOtherDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.service.customer_user_service.CustomerUserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerUserServiceController {
    @Autowired
    private CustomerUserServiceService customerUserServiceService;

    @ModelAttribute("contractList")
    public List<Contract> showContractList() {
        return customerUserServiceService.findAllByContract();
    }

    @ModelAttribute("contractDetailList")
    public List<ContractDetail> showContractDetailList() {
        return customerUserServiceService.findAllByContractDetail();
    }

    @ModelAttribute("attachServiceList")
    public List<AttachService> showAttachServiceList() {
        return customerUserServiceService.findAllByAttachService();
    }

    @GetMapping(value = {"/customer-user-service", "/customer-user-service/search"})
    public ModelAndView listCustomer(@PageableDefault(value = 3) Pageable pageable,
                                     @RequestParam Optional<String> name) {
        String nameValue = "";
        if (name.isPresent()) {
            nameValue = name.get();
        }
        ModelAndView modelAndView = new ModelAndView("/customer_user_service/list");
        Page<CustomerOtherDto> customers = customerUserServiceService.findByCustomerName(pageable, nameValue);
        modelAndView.addObject("nameValue", nameValue);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @PostMapping("/delete-customer-user-service")
    public String showDeleteForm(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        customerUserServiceService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Customer user service deleted successfully!!!");
        return "redirect:/customer-user-service";
    }
}