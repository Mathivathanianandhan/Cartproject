package com.Shopping.Cart.service;

import org.springframework.stereotype.Service;

import com.Shopping.Cart.entity.Customer;
import com.Shopping.Cart.repository.CusttomerRepo;

@Service
public class CustomerService {
	private CusttomerRepo customerRepo;
	public CustomerService(CusttomerRepo customerRepo)
	{
		this.customerRepo=customerRepo;
	}
	public Customer createCustomer(Customer customer)
	{
		return customerRepo.save(customer);
	}
	public Integer isCustomerPresent(Customer cust1) {
		
		
		Customer cu=customerRepo.getCustomerByEmailAndName(cust1.getEmail(),cust1.getName());
		return cu!=null?cu.getId():null;
	}
	

}
