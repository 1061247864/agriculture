package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Goods;
import com.service.GoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/get")
	public List<Goods> show(@RequestParam(value="goodsname",required=false) String goodsname, @RequestParam(value="typeid",required=false) Integer typeid,
			@RequestParam(value="shopid",required=false) Integer shopid) {
		return goodsService.show(goodsname, typeid, shopid);
	}
}
