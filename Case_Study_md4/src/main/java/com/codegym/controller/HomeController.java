package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome() {
        return "/frame/home";
    }

    @GetMapping("/login")
    public String shoFormLogin() {
        return "/login";
    }

    @GetMapping("/error")
    public String accessDenied() {
        return "/error";
    }
}