package com.Shopping.Cart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Shopping.Cart.entity.Product;
import com.Shopping.Cart.repository.ProductRepo;
@Service
public class ProductService {
private ProductRepo productRepo;
public ProductService(ProductRepo productRepo)
{
	this.productRepo=productRepo;
}
public Product create(Product product)
{
	return productRepo.save(product);
}
public List<Product> getAllProducts()
{
	return this.productRepo.findAll();
}
}
