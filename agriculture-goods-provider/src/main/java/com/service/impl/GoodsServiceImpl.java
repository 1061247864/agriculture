package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.GoodsMapper;
import com.pojo.Goods;
import com.pojo.User;
import com.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Goods> show(Goods goods) {
		return goodsMapper.show(goods);
	}
	
	@Override
	public PageInfo<Goods> showGoods(Integer currentPage,Goods goods) {
		PageHelper.startPage(currentPage, 2);
		List<Goods> findAll = goodsMapper.show(goods);
		PageInfo<Goods> pageInfo = new PageInfo<>(findAll);
		return pageInfo;
	}
	
	@Override
	public int insert(Goods goods) {
		return goodsMapper.insert(goods);
	}

	@Override
	public int del(Integer goodsid) {
		return goodsMapper.del(goodsid);
	}

	@Override
	public int update(Goods goods) {
		return goodsMapper.update(goods);
	}
}
