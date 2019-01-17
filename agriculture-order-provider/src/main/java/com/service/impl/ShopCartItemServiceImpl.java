package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ShopcItemMapper;
import com.pojo.ShopcItem;
import com.service.ShopCartItemService;

@Service
public class ShopCartItemServiceImpl implements ShopCartItemService{
	
	@Autowired
	private ShopcItemMapper shopcItemMapper;

	@Override
	public int addItem(ShopcItem shopcItem) {
		// TODO Auto-generated method stub
		return shopcItemMapper.insert(shopcItem);
	}

	@Override
	public int updItem(ShopcItem shopcItem) {
		// TODO Auto-generated method stub
		return shopcItemMapper.updateByPrimaryKeySelective(shopcItem);
	}

	@Override
	public int delItem(List<Integer> list) {
		// TODO Auto-generated method stub
		return shopcItemMapper.delShopCartItem(list);
	}

}
