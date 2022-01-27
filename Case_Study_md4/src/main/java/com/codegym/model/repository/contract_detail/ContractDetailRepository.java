package com.codegym.model.repository.contract_detail;

import com.codegym.model.entity.contract_detail.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    @Query(value = "select * from contract_detail", nativeQuery = true)
    Page<ContractDetail> findAll(Pageable pageable);
}