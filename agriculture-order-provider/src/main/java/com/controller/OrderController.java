package com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Order;
import com.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("getOrder/{id}/{userId}/{countPrice}/{createdate}/{status}")
	public List<Order> selectOrder(@PathVariable(value="id",required=false) String id,
			@PathVariable(value="userId",required=false) String userId,
			@PathVariable(value="countPrice",required=false) String countPrice,
			@PathVariable(value="createdate",required=false) String createdate,
			@PathVariable(value="status",required=false) String status
			) {
		Order order = new Order(Integer.valueOf(id), Integer.valueOf(userId), countPrice,null, Integer.valueOf(status));
		return orderService.getOrderList(order);
		
	}
	
}
