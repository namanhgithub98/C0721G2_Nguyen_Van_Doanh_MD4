package com.codegym.model.repository.security;

import com.codegym.model.entity.security.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {
}