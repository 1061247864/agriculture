package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ShopCartMapper;
import com.pojo.ShopCart;
import com.service.ShopCartService;

@Service
public class ShopCartServiceImpl implements ShopCartService {

	@Autowired
	private ShopCartMapper shopCartMapper;
	
	@Override
	public int addShopCart(ShopCart shopCart) {
		// TODO Auto-generated method stub
		return shopCartMapper.insert(shopCart);
	}

	@Override
	public int updShopCar(ShopCart shopCart) {
		// TODO Auto-generated method stub
		return shopCartMapper.updateByPrimaryKeySelective(shopCart);
	}

	@Override
	public ShopCart selectByShopcId(Integer shopcId) {
		// TODO Auto-generated method stub
		return shopCartMapper.selectByPrimaryKey(shopcId);
	}

}
