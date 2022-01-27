package com.codegym.model.entity.employee;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.security.AppUser;

import javax.persistence.*;
import java.util.Set;

@Entity

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;

    @Column(name = "employee_birthday", columnDefinition = "DATE")
    private String employeeBirthday;
    private String employeeIdCard;
    private Integer employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;

    @ManyToOne(targetEntity = PositionEmpl.class)
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private PositionEmpl positionEmpl;

    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "education_degree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Set<Contract> contract;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_name", referencedColumnName = "userName")
    private AppUser appUser;


    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String employeeBirthday, String employeeIdCard, Integer employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, PositionEmpl positionEmpl, EducationDegree educationDegree, Division division, Set<Contract> contract) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.positionEmpl = positionEmpl;
        this.educationDegree = educationDegree;
        this.division = division;
        this.contract = contract;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Integer getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Integer employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public PositionEmpl getPositionEmpl() {
        return positionEmpl;
    }

    public void setPositionEmpl(PositionEmpl positionEmpl) {
        this.positionEmpl = positionEmpl;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }
}