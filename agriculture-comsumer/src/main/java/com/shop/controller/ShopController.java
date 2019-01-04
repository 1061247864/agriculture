package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Shop;
import com.service.ShopClientService;

@RestController
@RequestMapping("shop")
public class ShopController {

	
	@Autowired
	ShopClientService shopClientService;
	
	@PostMapping(value="/findshops")
	public List<Shop> findShops(@RequestParam(value="shopName",required=false)String shopName){
		return shopClientService.findShops(shopName);
	}
}
