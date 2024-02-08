package com.Shopping.Cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shopping.Cart.entity.Customer;
import com.Shopping.Cart.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

	Order save(Order order);

}
