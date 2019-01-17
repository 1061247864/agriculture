package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pojo.Goods;

@Mapper
public interface GoodsMapper {

	int insert(@Param("goods") Goods goods);

	int del(@Param("goodsid") Integer goodsid);

	int update(@Param("goods") Goods goods);
	
	/* List<Goods> show(@Param("goods") Goods goods); */
	List<Goods> goodsList();


}
