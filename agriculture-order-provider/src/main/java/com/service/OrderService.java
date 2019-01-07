package com.service;


import com.github.pagehelper.PageInfo;
import com.pojo.Order;
public interface OrderService {
	PageInfo<Order> getOrderList(Integer currentPage,Order order);
	int delOrderById(Integer id);
	int addOrder(Order order);
	int updOrder(Order order);
}
