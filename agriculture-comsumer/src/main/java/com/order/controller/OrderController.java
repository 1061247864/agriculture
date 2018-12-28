package com.order.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.OrderClientService;
import com.pojo.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
  @Autowired
 private OrderClientService  orderClientService;
  

 
  @RequestMapping("/getOrder")
  public List<Order> getOrder(@RequestParam(value="id",required=false) String id,
			@RequestParam(value="userId",required=false) String userId,
			@RequestParam(value="countPrice",required=false) String countPrice,
			@RequestParam(value="createdate",required=false) String createdate,
			@RequestParam(value="status",required=false) String status
			)
  { 
	 return  orderClientService.findOrder(id, userId, countPrice, createdate, status);
  }
  
  
}
