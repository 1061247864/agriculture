package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pojo.Goods;


@Mapper
public interface GoodsMapper {
	
	int insert(Goods goods);
	
	int del(Integer goods);

    int update(Goods goods);
	
	List<Goods> show(@Param("goodsname") String goodsname, @Param("typeid") Integer typeid, @Param("shopid") Integer shopid);

}
