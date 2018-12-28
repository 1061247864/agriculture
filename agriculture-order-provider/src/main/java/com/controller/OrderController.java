package com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Order;
import com.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("getOrder")
	public List<Order> selectOrder(@RequestParam(value="id",required=false) String id,
			@RequestParam(value="userId",required=false) String userId,
			@RequestParam(value="countPrice",required=false) String countPrice,
			@RequestParam(value="createdate",required=false) String createdate,
			@RequestParam(value="status",required=false) String status
			) {
		int intId = 0;
		int intUserId = 0;
		int intStatue = -1;
		Date date = null;
		if (id!=null) {
			intId = Integer.valueOf(id);
		}
		if (userId!=null) {
			intUserId = Integer.valueOf(userId);
		}
		if (createdate!=null) {
			date=null;
		}
		if (status!=null) {
			intStatue = Integer.valueOf(status);
		}
		Order order = new Order(intId, intUserId, countPrice,date, intStatue);
		return orderService.getOrderList(order);
		
	}
	
}
