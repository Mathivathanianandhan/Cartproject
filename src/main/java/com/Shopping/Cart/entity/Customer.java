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
@ToString
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cust1")
public class Customer {

public Customer(String name, String email) {
	this.name=name;
	this.email=email;
	}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String email;
}
