package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.ShopCart;
import com.pojo.ShopcItem;
import com.service.ShopCartItemService;
import com.service.ShopCartService;

@RestController
@RequestMapping("shopCart")
public class ShopCartController {
	
	@Autowired
	private ShopCartService shopCartService;
	
	@Autowired
	private ShopCartItemService shopCartItemService;
	
	@PostMapping("addShopCart")
	public ShopCart addShopCart(@RequestBody ShopCart shopCart,@RequestParam("goodId") int goodId,@RequestParam("count")int count) {
		ShopcItem shopcItem = new ShopcItem();
		ShopCart returnShopCart = null;
		shopcItem.setCount(count);
		shopcItem.setGoodId(goodId);
		if (shopCart.getShopcId()==null) {
			int flag = shopCartService.addShopCart(shopCart);
			if (flag>0) {
				shopcItem.setShopcId(shopCart.getShopcId());
				shopCartItemService.addItem(shopcItem);
				returnShopCart = shopCartService.selectByShopcId(shopCart.getShopcId());
			}
		}else { 
			int flag  = shopCartService.updShopCar(shopCart);
			if (flag>0) {
				shopcItem.setShopcId(shopCart.getShopcId());
				shopCartItemService.addItem(shopcItem);
				returnShopCart = shopCartService.selectByShopcId(shopCart.getShopcId());
			}
		}
		return returnShopCart;
	}
}
