package com.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pojo.User;

@FeignClient("USERPROVIDER")
public interface UserClientService {
	
	@Cacheable(key="#p0",value="findUserById")
	@GetMapping("/user/get/{id}")
	public User findUserById(@PathVariable("id")String id);

}
