package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.pojo.GoodType;
import com.pojo.Goods;
import com.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/get")
	public PageInfo<Goods> showGoods(@RequestParam(value = "currentPage", required = false,defaultValue="1") Integer currentPage,
			 Goods goods){
		return goodsService.showGoods(currentPage, goods);
	}

	@RequestMapping("/insert")
	public int insert(Goods goods) {
		return goodsService.insert(goods);
	}
	
	@RequestMapping("/del")
	public int del(@RequestParam("goodsid") Integer goodsid) {
		return goodsService.del(goodsid);
	}
	
	@RequestMapping("/update")
	public int update(Goods goods) {
		return goodsService.update(goods);
	}
	
	@RequestMapping("/gettype")
	public List<GoodType> showType(){
		return goodsService.getGoodTypeList();
	}
}
