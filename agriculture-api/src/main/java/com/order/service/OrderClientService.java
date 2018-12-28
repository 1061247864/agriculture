package com.order.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.Order;

@FeignClient("ORDERPROVIDER")
public interface OrderClientService {
	
	//@Cacheable(key="#p0",value="findUserById")
	@RequestMapping("getOrder")
	public List<Order> findOrder(@RequestParam(value="id",required=false) String id,
			@RequestParam(value="userId",required=false) String userId,
			@RequestParam(value="countPrice",required=false) String countPrice,
			@RequestParam(value="createdate",required=false) String createdate,
			@RequestParam(value="status",required=false) String status
			);

}
