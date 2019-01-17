package com.order.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.ShopCartClientService;
import com.pojo.ShopCart;
import com.pojo.ShopcItem;
import com.pojo.ShopcItemVo;

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
	
	@PostMapping("updShopcItem")
	public ShopCart updShopcItem(ShopcItem shopcItem,Integer shopcId) {
		return shopCartClientService.updShopcItem(shopcItem, shopcId);
		
	}
	@PostMapping("delCartItems")
	public ShopCart delCartItems(ShopcItemVo shopcItemVo,Integer shopcId)
	{
		return shopCartClientService.delCartItems(shopcItemVo,shopcId);
		
	}
	
}
