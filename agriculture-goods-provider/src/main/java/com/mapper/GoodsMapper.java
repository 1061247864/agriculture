package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pojo.Goods;

@Mapper
public interface GoodsMapper {

	public int insert(@Param("goods") Goods goods);

	public int del(@Param("goodsid") Integer goodsid);

	public int update(@Param("goods") Goods goods);

	public List<Goods> show(@Param("goods") Goods goods);

}
