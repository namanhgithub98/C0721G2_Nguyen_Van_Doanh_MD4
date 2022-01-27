package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.PositionEmpl;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

public class EmployeeDto implements Validator {
    private Integer employeeId;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!")
    private String employeeName;

    private String employeeBirthday;

    @NotEmpty
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Please re-enter in the format: XXXXXXXXX or XXXXXXXXXXXX (X: 0-9)")
    private String employeeIdCard;

    @NotNull
    @Min(1)
    private Integer employeeSalary;

    @NotEmpty
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Please re-enter in the format: 090xxxxxxx or 091xxxxxxx " +
                    "or (84)+90xxxxxxx or (84)+91xxxxxxx (x: 0-9)")
    private String employeePhone;

    @NotBlank
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",
            message = "Please re-enter in the format: abc@gmail.com or abc@gmail.com.vn")
    private String employeeEmail;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!")
    private String employeeAddress;

    private PositionEmpl positionEmpl;
    private EducationDegree educationDegree;
    private Division division;
    private Set<Contract> contract;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        String stringDate = employeeDto.getEmployeeBirthday();

        if (stringDate.equals("")) {
            errors.rejectValue("employeeBirthday", "employeeBirthday.notBlank");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        LocalDate dateNow = LocalDate.now();

        int age = Period.between(date, dateNow).getYears();

        if (date.compareTo(dateNow) > 0) {
            errors.rejectValue("employeeBirthday", "employeeBirthday.futureDay");
        }

        if (date.compareTo(dateNow) == 0) {
            errors.rejectValue("employeeBirthday", "employeeBirthday.nowDay");
        }

        if (age < 18) {
            errors.rejectValue("employeeBirthday", "employeeBirthday.age");
        }
    }

    public EmployeeDto() {
    }

    public EmployeeDto(Integer employeeId, @NotEmpty @NotBlank @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!") String employeeName, String employeeBirthday, @NotEmpty @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Please re-enter in the format: XXXXXXXXX or XXXXXXXXXXXX (X: 0-9)") String employeeIdCard, @NotNull @Min(1) Integer employeeSalary, @NotEmpty @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Please re-enter in the format: 090xxxxxxx or 091xxxxxxx " +
                    "or (84)+90xxxxxxx or (84)+91xxxxxxx (x: 0-9)") String employeePhone, @NotBlank @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",
            message = "Please re-enter in the format: abc@gmail.com or abc@gmail.com.vn") String employeeEmail, @NotEmpty @NotBlank @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!") String employeeAddress, PositionEmpl positionEmpl, EducationDegree educationDegree, Division division, Set<Contract> contract) {
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