package com.order.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.ShopCart;

@FeignClient("ORDERPROVIDER")
public interface ShopCartClientService {
	@PostMapping("shopCart/addShopCart")
	public ShopCart addShopCart(ShopCart shopCart,@RequestParam("goodId") int goodId,@RequestParam("count")int count);
	
	@PostMapping("shopCart/getShopCartById")
	public ShopCart getShopCartById(ShopCart shopCart);
}
