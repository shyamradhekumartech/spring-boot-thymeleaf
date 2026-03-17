package com.example.app.repository;

import com.example.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 <p>
     For our Customer domain, we will create the following repository to load a
     page of Customers from the database:
 </p>

 <code>
     The JpaRepository extends the PagingAndSortingRepository interface,
     which provides methods to retrieve entities using the pagination and sorting abstraction.
 </code>

 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String name);

}
