package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Shop;
import com.service.ShopService;

@RequestMapping("/shop")
@RestController
public class ShopController {
	@Autowired
	ShopService shopService;

	@PostMapping("/finds")
	public List<Shop> finsShops(@RequestParam(value="shopName",required=false)String shopName) {
		return shopService.findShops(shopName);
		
	};
}
