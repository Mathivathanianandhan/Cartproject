package com.Shopping.Cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shopping.Cart.entity.Customer;
import com.Shopping.Cart.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findAll();

	

}
