package com.codegym.model.service.customer_user_service;

import com.codegym.dto.CustomerOtherDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.repository.contract.ContractRepository;
import com.codegym.model.repository.contract_detail.AttachServiceRepository;
import com.codegym.model.repository.contract_detail.ContractDetailRepository;
import com.codegym.model.repository.customer_user_service.CustomerUserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUserServiceServiceImpl implements CustomerUserServiceService {
    @Autowired
    private CustomerUserServiceRepository customerUserServiceRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public void save(Customer customer) {
        customerUserServiceRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerUserServiceRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        customerUserServiceRepository.deleteById(id);
    }

    @Override
    public Page<CustomerOtherDto> findByCustomerName(Pageable pageable, String name) {
        return customerUserServiceRepository.getCustomerUserService(pageable, "%" + name + "%");
    }

    @Override
    public List<Contract> findAllByContract() {
        return contractRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllByContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<AttachService> findAllByAttachService() {
        return attachServiceRepository.findAll();
    }
}