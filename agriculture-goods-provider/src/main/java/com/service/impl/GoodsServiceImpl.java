package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.GoodsMapper;
import com.pojo.Goods;
import com.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsMapper goodsMapper;
	@Override
	public List<Goods> show(String goodsname, Integer typeid, Integer shopid) {
		return goodsMapper.show(goodsname, typeid, shopid);
	}
}
