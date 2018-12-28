package com.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goods.service.GoodsClientService;
import com.pojo.Goods;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsClientService goodsClientService;
	
	@RequestMapping("/get")
	public List<Goods> show(@RequestParam(value="goodsname",required=false) String goodsname, @RequestParam(value="typeid",required=false) Integer typeid,
			@RequestParam(value="shopid",required=false) Integer shopid) {
		return goodsClientService.show(goodsname, typeid, shopid);
	}
}
