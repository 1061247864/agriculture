package com.service;

import java.util.List;


import com.pojo.Order;
public interface OrderService {
	List<Order> getOrderList(Order order);
}
