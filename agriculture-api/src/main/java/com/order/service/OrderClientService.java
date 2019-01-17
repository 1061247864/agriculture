package com.order.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.pojo.Order;

@FeignClient("ORDERPROVIDER")
public interface OrderClientService {

	@RequestMapping("order/getOrder")
	public PageInfo<Order> getOrderList(
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
			Order order);

	@RequestMapping("order/delOrder/{id}")
	public int delOrder(@PathVariable(value = "id", required = false) int id);

	@RequestMapping("order/addOrder")
	public int addOrder(Order order);

	@RequestMapping("order/updOrder")
	public int updOrder(Order order);

	@RequestMapping("order/updatesorder")
	int updatesorder(@RequestParam(value = "orderId") Integer orderId, @RequestParam(value = "status") Integer status);

}
