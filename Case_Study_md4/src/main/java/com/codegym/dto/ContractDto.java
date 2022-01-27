package com.codegym.dto;

import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;


public class ContractDto implements Validator {
    private Integer contractId;

    private String contractStartDate;

    private String contractEndDate;

    @NotNull
    @Positive
    private Integer contractDeposit;

    @Positive
    private Integer contractTotalMoney;

    private Employee employee;
    private Customer customer;
    private Service service;
    private Set<ContractDetail> contractDetail;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        String stringStartDate = contractDto.getContractStartDate();
        String stringEndDate = contractDto.getContractEndDate();

        if (stringStartDate.equals("") || stringEndDate.equals("")) {
            errors.rejectValue("contractStartDate", "contractStartDate.notBlank");
            errors.rejectValue("contractEndDate", "contractEndDate.notBlank");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(stringStartDate, formatter);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDate = LocalDate.parse(stringEndDate, formatter1);
        LocalDate dateNow = LocalDate.now();

        if (startDate.compareTo(dateNow) < 0) {
            errors.rejectValue("contractStartDate", "contractStartDate.pastDay");
        }

        if (startDate.compareTo(endDate) > 0 || startDate.compareTo(endDate) == 0) {
            errors.rejectValue("contractEndDate", "contractEndDate.day");
        }
    }

    public ContractDto() {
    }

    public ContractDto(Integer contractId, String contractStartDate, String contractEndDate, @NotNull @Positive Integer contractDeposit, @Positive Integer contractTotalMoney, Employee employee, Customer customer, Service service, Set<ContractDetail> contractDetail) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.contractDetail = contractDetail;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Integer getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Integer contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Integer getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Integer contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}