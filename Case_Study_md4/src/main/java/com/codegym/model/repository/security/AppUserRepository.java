package com.codegym.model.repository.security;

import com.codegym.model.entity.security.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUserName(String userName);
}