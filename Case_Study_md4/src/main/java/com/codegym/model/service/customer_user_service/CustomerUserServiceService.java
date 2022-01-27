package com.codegym.model.service.customer_user_service;

import com.codegym.dto.CustomerOtherDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerUserServiceService {
    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Integer id);

    Page<CustomerOtherDto> findByCustomerName(Pageable pageable, String name);

    List<Contract> findAllByContract();

    List<ContractDetail> findAllByContractDetail();

    List<AttachService> findAllByAttachService();
}