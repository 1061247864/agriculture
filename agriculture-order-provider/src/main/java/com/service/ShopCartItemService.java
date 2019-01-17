package com.service;


import java.util.List;

import com.pojo.ShopcItem;

public interface ShopCartItemService {
	int addItem(ShopcItem shopcItem);
	
	int updItem(ShopcItem shopcItem);
	
	int delItem(List<Integer> list);
}
