package com.codegym.model.service.security;

import com.codegym.model.entity.security.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> findAll();

    void save(AppUser appUser);

    void update(AppUser appUser);
}