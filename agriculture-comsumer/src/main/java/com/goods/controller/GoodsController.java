package com.goods.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.goods.service.GoodsClientService;
import com.pojo.Goods;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsClientService goodsClientService;
	
	@RequestMapping("/get")
	public PageInfo<Goods> show(@RequestParam(value = "currentPage", required = false,defaultValue="1") Integer currentPage,Goods goods) {
		return goodsClientService.show(currentPage, goods);
	}
	
	@RequestMapping("/insert")
	public int insert(Goods goods) {
		return goodsClientService.insert(goods);
	}
	
	@RequestMapping("/del")
	public int del(@RequestParam("goodsid") Integer goodsid) {
		return goodsClientService.del(goodsid);
	}
	
	@RequestMapping("/update")
	public int update(Goods goods) {
		return goodsClientService.update(goods);
	}
}
