package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface CustomerOtherDto {
    String getCustomerId();

    String getCustomerCode();

    String getCustomerName();

    String getCustomerIdCard();

    String getCustomerAddress();

    String getContractId();

    String getContractDetailId();

    String getAttachServiceName();

    String getTotalMoneyAttachService();

    String getTotalMoney();

}