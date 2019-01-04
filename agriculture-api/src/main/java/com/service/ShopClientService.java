package com.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.Shop;

@FeignClient("USERPROVIDER")
public interface ShopClientService {
	@PostMapping("/shop/finds")
	public List<Shop> findShops(@RequestParam(value="shopName",required=false)String shopName);
}
