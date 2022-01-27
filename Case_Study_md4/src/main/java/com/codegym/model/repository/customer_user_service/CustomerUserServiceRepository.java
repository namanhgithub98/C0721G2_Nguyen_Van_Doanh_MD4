package com.codegym.model.repository.customer_user_service;

import com.codegym.dto.CustomerOtherDto;
import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerUserServiceRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select customer.customer_id as customerId, customer.customer_code as customerCode, customer.customer_name as customerName," +
            "customer.customer_id_card as customerIdCard, customer.customer_address as customerAddress, contract.contract_id as contractId, " +
            "contract_detail.contract_detail_id as contractDetailId, attach_service.attach_service_name as attachServiceName," +
            "sum(contract_detail.quantity * attach_service.attach_service_cost) as totalMoneyAttachService " +
//            "sum(sum(contract_detail.quantity * attach_service.attach_service_cost) + service.service_cost) as totalMoney " +
            "from customer " +
            "join contract on customer.customer_id = contract.customer_id " +
            "join service on contract.service_id = service.service_id " +
            "join contract_detail on contract.contract_id = contract_detail.contract_id " +
            "join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id " +
            "where customer.customer_name like %?1% " +
            "group by contract.contract_id", nativeQuery = true,
            countQuery = "select count(*) " +
                    "from customer " +
                    "join contract on customer.customer_id = contract.customer_id " +
                    "join service on contract.service_id = service.service_id " +
                    "join contract_detail on contract.contract_id = contract_detail.contract_id " +
                    "join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id " +
                    "where customer.customer_name like %?1% " +
                    "group by contract.contract_id")
    Page<CustomerOtherDto> getCustomerUserService(Pageable pageable, String name);
}
