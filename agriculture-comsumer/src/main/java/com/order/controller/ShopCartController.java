package com.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.ShopCartClientService;
import com.pojo.ShopCart;

@RestController
@RequestMapping("/shopCart")
public class ShopCartController {
	
	@Autowired
	private ShopCartClientService shopCartClientService;
	
	@PostMapping("addShopCart")
	public ShopCart addShopCart(ShopCart shopCart,int goodId,int count) {
		return shopCartClientService.addShopCart(shopCart,goodId,count);
	}

	@PostMapping("getShopCartById")
	public ShopCart getShopCartById(ShopCart shopCart) {
		return shopCartClientService.getShopCartById(shopCart);
	}
	
}
