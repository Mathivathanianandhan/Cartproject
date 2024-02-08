package com.Shopping.Cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shopping.Cart.entity.Customer;

public interface CusttomerRepo extends JpaRepository<Customer, Integer>{

	Customer save(Customer customer);

	Customer getCustomerByEmailAndName(String email, String name);

	
	
}
