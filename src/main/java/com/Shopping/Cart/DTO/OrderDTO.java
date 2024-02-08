package com.Shopping.Cart.DTO;

import java.util.List;

import com.Shopping.Cart.entity.ShoppingCart;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
private String orderDescription;
public String getOrderDescription() {
	return orderDescription;
}
public void setOrderDescription(String orderDescription) {
	this.orderDescription = orderDescription;
}
public List<ShoppingCart> getShopcart() {
	return shopcart;
}
public void setShopcart(List<ShoppingCart> shopcart) {
	this.shopcart = shopcart;
}
public String getCustomerEmail() {
	return customerEmail;
}
public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
private List<ShoppingCart> shopcart;
private String customerEmail;
private String customerName;
}
