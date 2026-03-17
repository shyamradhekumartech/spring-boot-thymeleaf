package com.example.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MySecondController {

    @GetMapping("/public")
    public String publicApi() {
        return "Accessible by everyone authenticated";
    }

    @GetMapping("/admin-only")
    public String adminApi() {
        return "Welcome, Admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteApi(@PathVariable Long id) {
        return "Data " + id + " deleted";
    }

}
