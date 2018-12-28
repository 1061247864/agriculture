package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public PageInfo<Goods> showGoods(@RequestParam(value = "currentPage", required = false) Integer currentPage,
			Goods goods) {
		return goodsService.showGoods(currentPage, goods);
	}

	@RequestMapping("/insert")
	public int insert(@RequestParam("goods") Goods goods) {
		return goodsService.insert(goods);
	}
}
