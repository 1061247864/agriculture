package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.pojo.Order;
import com.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("getOrder")
	public PageInfo<Order> selectOrder(
			@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage,Order order
			) {
		return orderService.getOrderList(currentPage, order);
		
	}
	
	@RequestMapping("delOrder/{id}")
	public int delOrder(@PathVariable(value="id",required=false)int id) {
		return orderService.delOrderById(id);

	}
	
}
