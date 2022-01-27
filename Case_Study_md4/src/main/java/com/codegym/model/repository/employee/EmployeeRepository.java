package com.codegym.model.repository.employee;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
//    @Query(value = "select * from employee where employee.employee_name like %?1% ", nativeQuery = true)
//    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name);

    @Query(value = "select * from employee where employee_name like :nameSearch and employee_email like :emailSearch and position_id like :positionEmployee " , nativeQuery = true)
    Page<Employee> search(Pageable pageable, @Param("nameSearch")  String nameSearch ,
                          @Param("emailSearch")  String emailSearch ,
                          @Param("positionEmployee")  String positionEmployee );
}
