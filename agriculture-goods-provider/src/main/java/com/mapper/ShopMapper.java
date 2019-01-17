package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Shop;

public interface ShopMapper {
	List<Shop> show(@Param("shop")Shop shop);
	void delshop(int id);
}