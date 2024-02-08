package com.Shopping.Cart.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="myorder3")
public class Order {
	


	public Order(String orderDescription, Customer cust1, List<ShoppingCart> shopcart) {
		
			this.orderDescription = orderDescription;
	        this.cust1 = cust1;
	        this.shopcart = shopcart;
		}
	


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String orderDescription;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="customer_id", referencedColumnName="id")
	private Customer cust1;
	
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=ShoppingCart.class)
	@JoinColumn(name="fid",referencedColumnName="id")
	private List<ShoppingCart> shopcart;
	

}
