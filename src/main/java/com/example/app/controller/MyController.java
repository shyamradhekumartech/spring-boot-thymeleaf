//package com.example.app.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Role based access control
// */
//@RestController
//@RequestMapping("/api")
//public class MyController {
//
//    @GetMapping("/public")
//    public String publicApi() {
//        return "Accessible by everyone authenticated";
//    }
//
//    @GetMapping("/admin-only")
//    @PreAuthorize("hasRole('ADMIN')")   // Only users with ROLE_ADMIN can access
//    public String adminApi() {
//        return "Welcome, Admin!";
//    }
//
//    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public String deleteData(@PathVariable Long id) {
//        return "Data " + id + " deleted";
//    }
//
//}
