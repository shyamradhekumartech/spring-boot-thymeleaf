package com.example.app.runner;

import com.example.app.model.Customer;
import com.example.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    @Autowired
    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (customerRepository.count() == 0) {
            System.out.println("Database is empty. initializing with 20 customers...");

            List<Customer> customers = new ArrayList<>();

            for (int i = 1; i <= 20; i++) {
                String name = "Customer " + i;
                String address = i + " Main Street, Cityville";
                customers.add(new Customer(name, address));
            }

            customerRepository.saveAll(customers);

            System.out.println("Successfully added 20 customers to H2 database.");

            // Verify insertion
            customerRepository.findAll().forEach(System.out::println);
        } else {
            System.out.println("Database already contains data. Skipping initialization.");
        }
    }
}