package com.codegym.model.repository.service;

import com.codegym.model.entity.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository<RentType, Integer> {
}