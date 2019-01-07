package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.pojo.Goods;
import com.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/get")
	public PageInfo<Goods> showGoods(@RequestParam(value = "currentPage", required = false,defaultValue="1") Integer currentPage,
		@RequestBody Goods goods/*,HttpServletResponse response*/) {
		/*response.addHeader("Access-Control-Allow-Origin","*");//允许所有来源访问 
		response.addHeader("Access-Control-Allow-Method","POST,GET");//允许访问的方式*/		
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
}
