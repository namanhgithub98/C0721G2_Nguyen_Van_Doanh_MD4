package com.codegym.model.repository.customer;

import com.codegym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query(value = "select * from customer where concat(customer_name,customer_id_card) like %:keyWord% ", nativeQuery = true)
//    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String keyWord);

    @Query(value = "select * from customer where customer_name like :nameSearch and customer_email like :emailSearch and customer_type_id like :idTypeCusSearch " , nativeQuery = true)
    Page<Customer> search(Pageable pageable, @Param("nameSearch")  String nameSearch ,
                          @Param("emailSearch")  String emailSearch ,
                          @Param("idTypeCusSearch")  String idTypeCusSearch );

}