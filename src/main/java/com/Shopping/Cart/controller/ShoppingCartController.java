package com.Shopping.Cart.controller;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Cart.DTO.OrderDTO;
import com.Shopping.Cart.DTO.ResponseOrderDTO;
import com.Shopping.Cart.entity.Customer;
import com.Shopping.Cart.entity.Order;
import com.Shopping.Cart.entity.Product;
import com.Shopping.Cart.service.CustomerService;
import com.Shopping.Cart.service.OrderService;
import com.Shopping.Cart.service.ProductService;
import com.Shopping.Cart.util.DateUtil;

@RestController
@RequestMapping("/api/shop")
public class ShoppingCartController {
	private OrderService orderService;
	private ProductService productService;
	private CustomerService customerService;
	public ShoppingCartController(OrderService orderService, ProductService productService, CustomerService customerService) {
        this.orderService = orderService;
        this.productService = productService;
        this.customerService = customerService;
    }
	private Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	 @GetMapping(value = "/getAllProducts")
	    public ResponseEntity<List<Product>> getAllProducts() {

	        List<Product> productList = productService.getAllProducts();

	        return ResponseEntity.ok(productList);
	    }
	 @GetMapping(value = "/getOrder/{orderId}")
	    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId) {

	        Order order = orderService.getOrderDetail(orderId);
	        return ResponseEntity.ok(order);
	    }
	 @PostMapping("/placeOrder")
	    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
	        logger.info("Request Payload " + orderDTO.toString());
	        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
	        float amount = orderService.getCartAmount(orderDTO.getShopcart());

	        Customer cust1 = new Customer(orderDTO.getCustomerName(),orderDTO.getCustomerEmail());
	        Integer cust1IdFromDb = customerService.isCustomerPresent(cust1);
	        if (cust1IdFromDb != null) {
	        	cust1.setId(cust1IdFromDb);
	            logger.info("Customer already present in db with id : " + cust1IdFromDb);
	        }else{
	        	cust1 = customerService.createCustomer(cust1);
	            logger.info("Customer saved.. with id : " + cust1.getId());
	        }
	        Order order = new Order(orderDTO.getOrderDescription(), cust1, orderDTO.getShopcart());
	        order = orderService.saveOrder(order);
	        logger.info("Order processed successfully..");

	        responseOrderDTO.setAmount(amount);
	        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
	        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
	        responseOrderDTO.setOrderId(order.getId());
	        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

	        logger.info("test push..");

	        return ResponseEntity.ok(responseOrderDTO);
	    }
	 @PostMapping("/create")
	 public Product create(@RequestBody Product product)
	 {
		 return productService.create(product);
	 }
	 @PostMapping("/createcustomer")
	 public Customer createCustomer(@RequestBody Customer customer)
		{
			return customerService.createCustomer(customer);
		}
	 @PostMapping("/createorder")
	 public Order saveOrder(Order order)
	 {
	 	return orderService.saveOrder(order);
	 }


}
