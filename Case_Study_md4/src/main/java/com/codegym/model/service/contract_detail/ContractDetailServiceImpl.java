package com.codegym.model.service.contract_detail;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.repository.contract.ContractRepository;
import com.codegym.model.repository.contract_detail.AttachServiceRepository;
import com.codegym.model.repository.contract_detail.ContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(Integer id) {
        return contractDetailRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        contractDetailRepository.deleteById(id);
    }

    @Override
    public Page<ContractDetail> findAllContractDetail(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public List<AttachService> findAllByAttachService() {
        return attachServiceRepository.findAll();
    }

    @Override
    public List<Contract> findAllByContract() {
        return contractRepository.findAll();
    }
}