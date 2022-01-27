package com.codegym.model.entity.service;


import javax.persistence.*;
import java.util.Set;

@Entity

public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    private String rentTypeName;
    private Integer rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> service;

    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName, Integer rentTypeCost, Set<Service> service) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.service = service;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Integer getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Integer rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
    }
}