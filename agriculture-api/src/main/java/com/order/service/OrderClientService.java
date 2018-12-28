package com.order.service;

import java.util.Date;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.pojo.Order;

@FeignClient("ORDERPROVIDER")
public interface OrderClientService {
	
	@RequestMapping("order/getOrder")
	public PageInfo<Order> findOrder(
			@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage,
			Order order
			);

	
	@RequestMapping("order/delOrder/{id}")
	public int delOrder(@PathVariable(value="id",required=false)int id);
}
