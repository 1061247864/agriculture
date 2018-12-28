package com.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.pojo.Goods;

import feign.Param;

public interface GoodsService {
	public int insert(Goods goods);
	
	public int del(Integer goodsid);

	public int update(Goods goods);
	
	public List<Goods> show(Goods goods);
	
	public PageInfo<Goods> showGoods(Integer currentPage,Goods goods);
}
