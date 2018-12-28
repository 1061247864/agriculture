package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pojo.Order;
import com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderService orderService;
	
	
	@Override
	public List<Order> getOrderList(Order order) {
		// TODO Auto-generated method stub
		return orderService.getOrderList(order);
	}

}
