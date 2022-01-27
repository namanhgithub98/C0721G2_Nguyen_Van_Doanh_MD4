package com.codegym.model.service.employee;


import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.employee.PositionEmpl;
import com.codegym.model.repository.employee.DivisionRepository;
import com.codegym.model.repository.employee.EducationDegreeRepository;
import com.codegym.model.repository.employee.EmployeeRepository;
import com.codegym.model.repository.employee.PositionEmplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionEmplRepository positionEmplRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

//    @Override
//    public Page<Employee> findByEmployeeName(Pageable pageable, String name) {
//        return employeeRepository.findAllByEmployeeNameContaining(pageable, name);
//    }

    @Override
    public List<Division> findAllByDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<PositionEmpl> findAllByPositionEmpl() {
        return positionEmplRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllByEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Page<Employee> search(Pageable pageable, String name, String email, String positionEmployee) {
        return employeeRepository.search(pageable, '%'+name+'%' , '%'+email+'%', '%'+positionEmployee+'%');
    }
}
