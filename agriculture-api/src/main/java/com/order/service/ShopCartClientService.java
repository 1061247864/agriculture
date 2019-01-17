package com.order.service;


import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.ShopCart;
import com.pojo.ShopcItem;
import com.pojo.ShopcItemVo;

@FeignClient("ORDERPROVIDER")
public interface ShopCartClientService {
	@PostMapping("shopCart/addShopCart")
	public ShopCart addShopCart(ShopCart shopCart,@RequestParam("goodId") int goodId,@RequestParam("count")int count);
	
	@PostMapping("shopCart/getShopCartById")
	public ShopCart getShopCartById(ShopCart shopCart);
	
	@PostMapping("shopCart/updShopcItem")
	public ShopCart updShopcItem(ShopcItem shopcItem,@RequestParam("shopcId")Integer shopcId);
	
	@PostMapping("shopCart/delCartItems")
	public ShopCart delCartItems(ShopcItemVo shopcItemVo,@RequestParam("shopcId")Integer shopcId);
}
