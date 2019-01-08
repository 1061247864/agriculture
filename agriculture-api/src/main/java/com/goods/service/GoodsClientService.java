package com.goods.service;


import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.pojo.GoodType;
import com.pojo.Goods;
import com.pojo.Shop;

@FeignClient("GOODSPROVIDER")
public interface GoodsClientService {

	// @Cacheable(key="#p0",value="showgoods")
	@RequestMapping("/goods/get")
	public PageInfo<Goods> show(@RequestParam(value = "currentPage", required = false,defaultValue="1") Integer currentPage,Goods goods);
	
	@RequestMapping("/goods/insert")
	public int insert(Goods goods);
	
	@RequestMapping("/goods/del")
	public int del(@RequestParam("goodsid") Integer goodsid);
	
	@RequestMapping("/goods/update")
	public int update(Goods goods);
	
	@RequestMapping("/goods/gettype")
	public List<GoodType> showType();
	
	@RequestMapping("/goods/getshop")
	public List<Shop> showShop();
}
