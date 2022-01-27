package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.service.contract_detail.ContractDetailService;
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
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;

    @ModelAttribute("contractList")
    public List<Contract> showContractList() {
        return contractDetailService.findAllByContract();
    }

    @ModelAttribute("attachServiceList")
    public List<AttachService> showAttachServiceList() {
        return contractDetailService.findAllByAttachService();
    }

    @GetMapping(value = "/contract-detail")
    public ModelAndView listContractDetail(@PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/contract_detail/list");
        Page<ContractDetail> contractDetails = contractDetailService.findAllContractDetail(pageable);
        modelAndView.addObject("contractDetails", contractDetails);
        return modelAndView;
    }

    @PostMapping("/delete-contract-detail")
    public String showDeleteForm(@RequestParam Optional<Integer> id, RedirectAttributes redirectAttributes) {
        ContractDetail contractDetail = contractDetailService.findById(id.get());
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Contract detail deleted successfully!!!");
        return "redirect:/contract-detail";
    }

    @GetMapping("/create-contract-detail")
    public String showCreateForm(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "contract_detail/create";
    }

    @PostMapping({"/create-contract-detail"})
    public String checkValidation(@Valid @ModelAttribute("contractDetailDto") ContractDetailDto contractDetailDto,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "contract_detail/create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("message", "Contract detail created successfully!!!");
            return "redirect:/contract-detail";
        }
    }

    @GetMapping("/edit-contract-detail/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        ContractDetail contractDetail = contractDetailService.findById(id);
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        BeanUtils.copyProperties(contractDetail, contractDetailDto);
        model.addAttribute("contractDetailDto", contractDetailDto);
        return "/contract_detail/edit";
    }

    @PostMapping({"/edit-contract-detail"})
    public String updateContractDetail(@Valid @ModelAttribute("contractDetailDto") ContractDetailDto contractDetailDto,
                                       BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/contract_detail/edit";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("message", "Contract Detail updated successfully!!!");
            return "redirect:/contract-detail";
        }
    }
}