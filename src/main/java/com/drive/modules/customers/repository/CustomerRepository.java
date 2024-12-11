package com.drive.modules.customers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.modules.customers.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Optional<Customer> findByEmail(String email);
}