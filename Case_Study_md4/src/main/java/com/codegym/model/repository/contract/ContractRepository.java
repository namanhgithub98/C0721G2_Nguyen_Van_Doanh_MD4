package com.codegym.model.repository.contract;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract ", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);
}