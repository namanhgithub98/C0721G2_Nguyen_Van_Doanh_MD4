package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import com.codegym.model.repository.contract.ContractRepository;
import com.codegym.model.repository.contract_detail.AttachServiceRepository;
import com.codegym.model.repository.contract_detail.ContractDetailRepository;
import com.codegym.model.repository.customer.CustomerRepository;
import com.codegym.model.repository.customer.CustomerTypeRepository;
import com.codegym.model.repository.employee.EmployeeRepository;
import com.codegym.model.repository.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findByContractId(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAllByEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Customer> findAllByCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Service> findAllByService() {
        return serviceRepository.findAll();
    }

    @Override
    public void totalMoney() {
        List<ContractDetail> contractDetails = contractDetailRepository.findAll();
        List<Contract> contracts = contractRepository.findAll();

        for (Contract contract : contracts) {
            Integer totalMoney = contract.getService().getServiceCost();
            for (ContractDetail contractDetail : contractDetails) {
                if (contractDetail.getContract().equals(contract)) {
                    totalMoney += contractDetail.getQuantity() * contractDetail.getAttachService().getAttachServiceCost();
                }
            }
            contract.setContractTotalMoney(totalMoney);
            contractRepository.save(contract);
        }
    }

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }
}