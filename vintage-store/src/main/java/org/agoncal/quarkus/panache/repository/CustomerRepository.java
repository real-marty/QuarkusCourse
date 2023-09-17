package org.agoncal.quarkus.panache.repository;

import org.agoncal.quarkus.jpa.Customer;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    // Your repository methods here, which can use SQL queries directly.

}