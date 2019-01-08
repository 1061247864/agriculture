package com.service;

import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.github.pagehelper.PageInfo;
import com.pojo.GoodType;
import com.pojo.Goods;
import com.pojo.Shop;

import feign.Param;

public interface GoodsService {
	public int insert(Goods goods);
	
	public int del(Integer goodsid);

	public int update(Goods goods);
	
	public PageInfo<Goods> showGoods(Integer currentPage,Goods goods);
	
	public List<GoodType> getGoodTypeList();
	
	public List<Shop> showShops(Shop shop);
}
