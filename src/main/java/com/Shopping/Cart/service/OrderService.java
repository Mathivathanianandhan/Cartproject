package com.Shopping.Cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Shopping.Cart.entity.Order;
import com.Shopping.Cart.entity.Product;
import com.Shopping.Cart.entity.ShoppingCart;
import com.Shopping.Cart.repository.OrderRepo;
import com.Shopping.Cart.repository.ProductRepo;

@Service
public class OrderService {
private ProductRepo productRepo;
private OrderRepo orderRepo;
public OrderService(ProductRepo productRepo,OrderRepo orderRepo)
{
	this.productRepo=productRepo;
	this.orderRepo=orderRepo;
}
public Order getOrderDetail(int orderId)
{
	Optional<Order> order=this.orderRepo.findById(orderId);
	return order.isPresent()?order.get():null;
	
}
public float getCartAmount(List<ShoppingCart> shoppingCartList)
{
	float totalcartamount=0f;
	float singlecartamount=0f;
	int availableQuantity=0;
	
	for(ShoppingCart cart:shoppingCartList)
	{
		int productId=cart.getProductId();
		Optional<Product> product=productRepo.findById(productId);
		if(product.isPresent())
		{
			Product product1=product.get();
			if(product1.getAvailableQuantity()<cart.getQuantity())
			{
				singlecartamount=product1.getPrice()*product1.getAvailableQuantity();
				cart.setQuantity(product1.getAvailableQuantity());
			}
			else
			{
				singlecartamount=cart.getQuantity()*product1.getPrice();
				availableQuantity=product1.getAvailableQuantity()-cart.getQuantity();
			}
			totalcartamount=totalcartamount+singlecartamount;
			product1.setAvailableQuantity(availableQuantity);
			availableQuantity=0;
			cart.setProductName(product1.getName());
			cart.setAmount(singlecartamount);
			productRepo.save(product1);
		}
				
	}
	return totalcartamount;
	
	
}
public Order saveOrder(Order order)
{
	return orderRepo.save(order);
}
}
