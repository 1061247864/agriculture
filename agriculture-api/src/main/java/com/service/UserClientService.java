package com.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.User;

@FeignClient("USERPROVIDER")
public interface UserClientService {

	@Cacheable(key = "#p0", value = "findUserById")
	@GetMapping("/user/get/{id}")
	public User findUserById(@PathVariable("id") String id);

	@PostMapping("user/findUserByCode")
	public User findUserByCode(@RequestParam("userCode")String userCode);

	@PostMapping("user/userRegistry")
	public Boolean userRegistry(User user);

}
