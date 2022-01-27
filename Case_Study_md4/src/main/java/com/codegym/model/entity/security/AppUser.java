package com.codegym.model.entity.security;

import com.codegym.model.entity.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    private String userName;
    private String userPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<AppRole> appRoles;

    @OneToOne(mappedBy = "appUser")
    private Employee employee;

    public AppUser() {
    }

    public AppUser(String userName, String userPassword, Set<AppRole> appRoles, Employee employee) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.appRoles = appRoles;
        this.employee = employee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<AppRole> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(Set<AppRole> appRoles) {
        this.appRoles = appRoles;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}