package com.codegym.model.repository.service;

import com.codegym.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    @Query(value = "select * from service where service.service_name like %?1% ", nativeQuery = true)
    Page<Service> findAllByServiceNameContaining(Pageable pageable, String name);
}