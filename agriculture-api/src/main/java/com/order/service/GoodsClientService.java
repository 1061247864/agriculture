package com.order.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pojo.User;

@FeignClient("GOODSPROVIDER")
public interface GoodsClientService {
	
	//@Cacheable(key="#p0",value="findUserById")
	@GetMapping("/getOrder/{id}/{userId}/{countPrice}/{createdate}/{status}")
	public User findOrder(@PathVariable(value="id",required=false) String id,
			@PathVariable(value="userId",required=false) String userId,
			@PathVariable(value="countPrice",required=false) String countPrice,
			@PathVariable(value="createdate",required=false) String createdate,
			@PathVariable(value="status",required=false) String status
			);

}
