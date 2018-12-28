package com.goods.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.Goods;

@FeignClient("GOODSPROVIDER")
public interface GoodsClientService {

	// @Cacheable(key="#p0",value="showgoods")
	@RequestMapping("/goods/get")
	public List<Goods> show(@RequestParam(value = "goodsname", required = false) String goodsname,
			@RequestParam(value = "typeid", required = false) Integer typeid,
			@RequestParam(value = "shopid", required = false) Integer shopid);
}
