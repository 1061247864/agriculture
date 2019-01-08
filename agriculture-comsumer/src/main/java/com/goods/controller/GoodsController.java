package com.goods.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.goods.service.GoodsClientService;
import com.pojo.GoodType;
import com.pojo.Goods;
import com.pojo.Shop;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsClientService goodsClientService;
	/*@CrossOrigin(origins = {"http://127.0.0.1:8020", "null","*"})*/
	@RequestMapping("/get")
	public PageInfo<Goods> show(@RequestParam(value = "currentPage", required = false,defaultValue="1") Integer currentPage,Goods goods,HttpServletResponse response) {
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
	
/*	@CrossOrigin(origins = {"http://127.0.0.1:8020", "null","*"})*/
	@RequestMapping("/gettype")
	public List<GoodType> showType(){
		return goodsClientService.showType();
	}
	
	@RequestMapping("/getshop")
	public List<Shop> showShop(Shop shop) {
		return goodsClientService.showShop();
	}
}
