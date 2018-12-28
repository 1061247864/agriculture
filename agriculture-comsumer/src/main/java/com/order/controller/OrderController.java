package com.order.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.order.service.OrderClientService;
import com.pojo.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
  @Autowired
 private OrderClientService  orderClientService;
  

 
  @RequestMapping("/getOrder")
  public PageInfo<Order> getOrder(
			@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage,
			Order order
			)
  { 
	 return  orderClientService.findOrder(currentPage,order);
  }
  
  
  @RequestMapping("/delOrder/{id}")
	public int delOrder(@PathVariable(value="id",required=false)int id) {
		return orderClientService.delOrder(id);

	}
  
}
