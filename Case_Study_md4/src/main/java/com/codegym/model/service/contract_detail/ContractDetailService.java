package com.codegym.model.service.contract_detail;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractDetailService {
    void save(ContractDetail contractDetail);

    ContractDetail findById(Integer id);

    void delete(Integer id);

    Page<ContractDetail> findAllContractDetail(Pageable pageable);

    List<AttachService> findAllByAttachService();

    List<Contract> findAllByContract();
}