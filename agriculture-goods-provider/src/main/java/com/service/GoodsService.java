package com.service;

import java.util.List;

import com.pojo.Goods;

import feign.Param;

public interface GoodsService {
	public List<Goods> show(@Param("goodsname") String goodsname, @Param("typeid") Integer typeid, @Param("shopid") Integer shopid);
}
