package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface ContractService {
    void save(Contract contract);

    Contract findById(Integer id);

    void delete(Integer id);

    Page<Contract> findByContractId(Pageable pageable);

    List<Employee> findAllByEmployee();

    List<Customer> findAllByCustomer();

    List<Service> findAllByService();

    void totalMoney();

    List<ContractDetail> findAllContractDetail();

    List<AttachService> findAllAttachService();
}
