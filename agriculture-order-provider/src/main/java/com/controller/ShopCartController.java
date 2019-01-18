package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.ShopCart;
import com.pojo.ShopcItem;
import com.pojo.ShopcItemVo;
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
	public ShopCart addShopCart(@RequestBody ShopCart shopCart, @RequestParam("goodId") int goodId,
			@RequestParam("count") int count) {
		ShopcItem shopcItem = new ShopcItem();
		ShopCart returnShopCart = null;
		shopcItem.setCount(count);
		shopcItem.setGoodId(goodId);
		if (shopCart.getShopcId() == null) {
			int flag = shopCartService.addShopCart(shopCart);
			if (flag > 0) {
				shopcItem.setShopcId(shopCart.getShopcId());
				shopCartItemService.addItem(shopcItem);
				returnShopCart = shopCartService.selectByShopcId(shopCart.getShopcId());
			}
		} else {
			int flag = shopCartService.updShopCar(shopCart);
			if (flag > 0) {
				shopcItem.setShopcId(shopCart.getShopcId());
				shopCartItemService.addItem(shopcItem);
				returnShopCart = shopCartService.selectByShopcId(shopCart.getShopcId());
			}
		}
		return returnShopCart;
	}

	@PostMapping("getShopCartById")
	public ShopCart getShopCartById(@RequestBody ShopCart shopCart) {
		ShopCart shopCar = shopCartService.selectByShopcId(shopCart.getShopcId());
		return shopCar;
	}

	@PostMapping("updShopcItem")
	public ShopCart updShopcItem(@RequestBody ShopcItem shopcItem, @RequestParam("shopcId") Integer shopcId,
			@RequestParam("countPrice") double countPrice) {
		int flag = shopCartItemService.updItem(shopcItem);
		ShopCart boolShopCart = new ShopCart();
		boolShopCart.setShopcId(shopcId);
		boolShopCart.setPriceCount(countPrice);
		int boole = shopCartService.updShopCar(boolShopCart);
		ShopCart shopCart = shopCartService.selectByShopcId(shopcId);
		if (flag > 0&&boole>0) {
			shopCart = shopCartService.selectByShopcId(shopcId);
		}
		return shopCart;

	}

	@PostMapping("delCartItems")
	public ShopCart delCartItems(@RequestBody ShopcItemVo shopcItemVo, @RequestParam("shopcId") Integer shopcId) {
		ShopCart secShopc =  shopCartService.selectByShopcId(shopcId);
		List<ShopcItem> list = secShopc.getShopcItem();
		int flag = shopCartItemService.delItem(shopcItemVo.getItemId());
		if (flag > 0) {
			ShopCart shopCart = shopCartService.selectByShopcId(shopcId);
			ShopCart boolShopCart = new ShopCart();
			boolShopCart.setShopcId(shopcId);
			if (shopCart == null) {
				int bool = shopCartService.delShopCart(shopcId);
				if (bool > 0) {
					return null;
				}
			} else {
				double priceCount = 0;
				for (ShopcItem shopcItem : list) {
					for (Integer itemId : shopcItemVo.getItemId()) {
						if (shopcItem.getShopcitemId().equals(itemId)) {
							priceCount+=shopcItem.getGoods().getPrice()*shopcItem.getCount();
						}
					}
				}
				boolShopCart.setPriceCount(secShopc.getPriceCount()-priceCount);
				shopCartService.updShopCar(boolShopCart);
				return shopCartService.selectByShopcId(shopcId);
			}
		}
		return shopCartService.selectByShopcId(shopcId);
	}
}
