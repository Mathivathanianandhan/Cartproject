package com.Shopping.Cart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shopcart")

public class ShoppingCart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private int productId;
	private String productName;
	private int quantity;
	private float amount;
	
}
