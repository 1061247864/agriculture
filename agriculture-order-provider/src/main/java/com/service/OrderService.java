package com.service;


import com.github.pagehelper.PageInfo;
import com.pojo.Order;
import com.pojo.OrderItem;
public interface OrderService {
	PageInfo<Order> getOrderList(Integer currentPage,Order order);
	int delOrderById(Integer id);
	int addOrder(Order order);
	int updOrder(Order order);
	void updatesorder(Integer id,Integer idvalue);
	int addOrderItem(OrderItem orderItem);
	Order getOrder(Integer orderId);
}
