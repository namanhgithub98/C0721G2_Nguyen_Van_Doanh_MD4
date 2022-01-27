package com.codegym.model.service.service;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();

    void save(Service service);

    Service findById(Integer id);

    void delete(Integer id);

    Page<Service> findByServiceName(Pageable pageable, String name);

    List<ServiceType> findAllByServiceType();

    List<RentType> findAllByRentType();
}