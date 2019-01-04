package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ShopMapper;
import com.pojo.Shop;
import com.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopMapper shopMapper;
	@Override
	public List<Shop> findShops(String shopName) {
		return shopMapper.findShops(shopName);
	}

}
