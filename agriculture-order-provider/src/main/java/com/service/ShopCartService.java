package com.service;

import com.pojo.ShopCart;

public interface ShopCartService {
	int addShopCart(ShopCart shopCart);
	
	int updShopCar(ShopCart shopCart);
	
	ShopCart selectByShopcId(Integer shopcId);
	
	
}
