package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.order.service.OrderClientService;
import com.pojo.Order;
import com.pojo.OrderItem;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderClientService orderClientService;

	@RequestMapping("/getOrder")
	public PageInfo<Order> findOrder(
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
			Order order) {
		return orderClientService.getOrderList(currentPage, order);
	}

	@RequestMapping("/delOrder/{id}")
	public int delOrder(@PathVariable(value = "id", required = false) int id) {
		return orderClientService.delOrder(id);

	}

	@RequestMapping("/addOrder")
	public int addOrder(Order order) {
		return orderClientService.addOrder(order);

	}

	@RequestMapping("/updOrder")
	public int updOrder(Order order) {
		return orderClientService.updOrder(order);

	}
	@RequestMapping("/updatesorder")
	public int updatesorder(@RequestParam(value = "orderId")Integer orderId,@RequestParam(value = "status")Integer status) {
		orderClientService.updatesorder(orderId, status);
		return 1;
	}

	@PostMapping("createOrderByShopCart")
	public Order createOrder(@RequestParam("shopcId") Integer shopcId) {
		return orderClientService.createOrder(shopcId);
	}
	
	@PostMapping("createOrderByGoodId")
	public Order createOrderByGoodId(OrderItem orderItem) {
		return orderClientService.createOrderByGoodId(orderItem);
	}
	
}
