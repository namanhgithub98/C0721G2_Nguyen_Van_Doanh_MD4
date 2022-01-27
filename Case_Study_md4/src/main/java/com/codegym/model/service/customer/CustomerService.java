package com.codegym.model.service.customer;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    void save(Customer customer);

    Customer findById(Integer id);

    void delete(Integer id);

//    Page<Customer> findByCustomerName(Pageable pageable, String name);

    List<CustomerType> findAllByCustomerType();

    Page<Customer> search(Pageable pageable, String name, String email, String idTypeCus);
}