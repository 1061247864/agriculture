package com.service;

import java.util.List;

import com.pojo.Shop;

public interface ShopService {
	public List<Shop> findShops (String shopName);
}
