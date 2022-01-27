package com.codegym.model.service.service;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.Service;
import com.codegym.model.entity.service.ServiceType;
import com.codegym.model.repository.service.RentTypeRepository;
import com.codegym.model.repository.service.ServiceRepository;
import com.codegym.model.repository.service.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service findById(Integer id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Page<Service> findByServiceName(Pageable pageable, String name) {
        return serviceRepository.findAllByServiceNameContaining(pageable, name);
    }

    @Override
    public List<ServiceType> findAllByServiceType() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllByRentType() {
        return rentTypeRepository.findAll();
    }
}