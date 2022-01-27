package com.codegym.model.service.employee;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.PositionEmpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);

    Employee findById(Integer id);

    void delete(Integer id);

//    Page<Employee> findByEmployeeName(Pageable pageable, String name);

    List<Division> findAllByDivision();

    List<PositionEmpl> findAllByPositionEmpl();

    List<EducationDegree> findAllByEducationDegree();

    Page<Employee> search(Pageable pageable, String name, String email, String positionEmployee);
}