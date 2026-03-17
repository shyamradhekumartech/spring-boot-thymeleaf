package com.example.app.controller;

import com.example.app.repository.CustomerRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 Let's create a controller which declares the '/customers' end-point to render the customers.
 The controller method takes optional 'page' and 'size' query parameters to retrieve a list of customers
 from the database. If no parameters are available, it uses the default values.
 */
@Controller
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public String customerPage(HttpServletRequest request, Model model) {
        int page = 0; // default page number is 0
        int size = 10; // default page size is 10

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        model.addAttribute("customers", customerRepository.findAll(PageRequest.of(page, size)));
        return "customers";
    }

}
