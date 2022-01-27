package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


public class ContractDetailDto {
    private Integer contractDetailId;
    private Contract contract;
    private AttachService attachService;

    @NotNull
    @Positive
    private Integer quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer contractDetailId, Contract contract, AttachService attachService, @NotNull @Positive Integer quantity) {
        this.contractDetailId = contractDetailId;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}