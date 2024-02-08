package com.Shopping.Cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shopping.Cart.entity.Customer;
import com.Shopping.Cart.entity.ShoppingCart;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer> {

}
